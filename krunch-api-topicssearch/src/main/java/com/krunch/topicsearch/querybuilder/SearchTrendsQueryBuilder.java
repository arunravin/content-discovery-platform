package com.krunch.topicsearch.querybuilder;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class SearchTrendsQueryBuilder {
	
	


	public static String genSearchTrendsQuery(String userName) {

		String strBaseQuery = " (select \"Keyword\" ,Date(\"CreatedAt\") as date1, count(\"Keyword\") as searchCount "
				+ " from \"User_Topics_Search_Keywords\" where " + "Date(\"CreatedAt\") = 'intervaldate' "
				+ " and \"UserName\" = '" + userName + "'" + "group by \"Keyword\" ,Date(\"CreatedAt\") order by searchCount desc limit 10) ";

		if (userName == null) {
			strBaseQuery = " (select \"Keyword\" ,Date(\"CreatedAt\") as date1, count(\"Keyword\") as searchCount"
					+ " from \"User_Topics_Search_Keywords\" where " + "Date(\"CreatedAt\") = 'intervaldate' "
					+ " group by \"Keyword\" ,Date(\"CreatedAt\") order by searchCount desc limit 10) ";

		}

		Map<Integer, String> hmIntervalDates = getDatesforanInterval(7);
		getDatesforanInterval(7);
		StringBuffer sbFinalQuery = new StringBuffer("");

		for (int i = 6; i >= 0; i--) {

			String strNthINtervalDate = hmIntervalDates.get(i).trim();

			String strQueryWithDateValue = strBaseQuery.replace("intervaldate", strNthINtervalDate);

			if (i == 6) {
				sbFinalQuery.append(strQueryWithDateValue);
			} else {
				sbFinalQuery.append("Union").append(strQueryWithDateValue);
			}

		}

		//System.out.println(sbFinalQuery.toString());

		return sbFinalQuery.toString();
	}

	public static Map<Integer, String> getDatesforanInterval(int interval) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");
		Calendar cal = Calendar.getInstance();
		// get starting date
		cal.add(Calendar.DAY_OF_YEAR, -7);

		Map<Integer, String> hmLastSevenDates = new HashMap<Integer, String>();

		// loop adding one day in each iteration

		for (int i = 0; i < 7; i++) {
			cal.add(Calendar.DAY_OF_YEAR, 1);
			hmLastSevenDates.put(i, sdf.format(cal.getTime()));
		}

		return hmLastSevenDates;

	}
	

}
