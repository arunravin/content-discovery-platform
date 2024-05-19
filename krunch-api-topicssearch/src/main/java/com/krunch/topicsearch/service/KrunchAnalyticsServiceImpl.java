package com.krunch.topicsearch.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.krunch.topicsearch.dao.KrunchAnalyticsRepositoryPgImpl;
import com.krunch.topicsearch.entity.SearchKeyWordData;
import com.krunch.topicsearch.entity.SearchTrendsModel;
import com.krunch.topicsearch.vo.SeaarchKeyword;

@Component
public class KrunchAnalyticsServiceImpl implements KrunchAnalyticsService {

	@Resource
	KrunchAnalyticsRepositoryPgImpl krunchAnalyticsDAOImpl;

	@Override
	public String postSearchKeyWords(SeaarchKeyword searckKeyWordVO) {

		return krunchAnalyticsDAOImpl.postSearchKeyWords(searckKeyWordVO);

	}

	@Override
	public List<String> getKrunchSearchKeywordsData() {
		// TODO Auto-generated method stub
		return krunchAnalyticsDAOImpl.getKrunchSearchKeywordsData();
	}

	@Override
	public List<SearchKeyWordData> getUsersSearchKeywordsData(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SearchTrendsModel> getKrunchSearchTrendsData(String userName) {
	
		List<SearchTrendsModel> lstUserSearchTrends = krunchAnalyticsDAOImpl.getKrunchSearchTrendsData(userName);
		List<SearchTrendsModel> lstOverallSearchTrends = krunchAnalyticsDAOImpl.getKrunchSearchTrendsData(null);
		
		Map<String,String> hmUserSearchTrends = new HashMap<String,String>();
		Map<String,String> hmOverallSearchTrends = new HashMap<String,String>();
		
				for (int i = 0; i < lstUserSearchTrends.size(); i++)  {
					
							SearchTrendsModel objSearchTrendsModel = lstUserSearchTrends.get(i);
							
			//				System.out.println("User : "+objSearchTrendsModel.toString());
					
							if(hmUserSearchTrends.containsKey(objSearchTrendsModel.getDate())) {
								String strConcatenatedVAlue = hmUserSearchTrends.get(objSearchTrendsModel.getDate()) + 
										"," +  objSearchTrendsModel.getMytopics();
								
								hmUserSearchTrends.put(objSearchTrendsModel.getDate(),strConcatenatedVAlue );
								
							} else {
								
								hmUserSearchTrends.put(objSearchTrendsModel.getDate(), objSearchTrendsModel.getMytopics());
								
							}
					
				} 
		
				for (int i = 0; i < lstOverallSearchTrends.size(); i++)  {
					
					SearchTrendsModel objSearchTrendsModel = lstOverallSearchTrends.get(i);
					
			//		System.out.println("OverAll : "+objSearchTrendsModel.toString());
					
			
					if(hmOverallSearchTrends.containsKey(objSearchTrendsModel.getDate())) {
						String strConcatenatedVAlue = hmOverallSearchTrends.get(objSearchTrendsModel.getDate()) + 
								"," +  objSearchTrendsModel.getMytopics();
						
						hmOverallSearchTrends.put(objSearchTrendsModel.getDate(),strConcatenatedVAlue );
						
					} else {
						
						hmOverallSearchTrends.put(objSearchTrendsModel.getDate(), objSearchTrendsModel.getMytopics());
						
					}
			
				} 
				
				Map<Integer, String> hmDatesIterator = 	getDatesforanInterval(7);
				List<SearchTrendsModel> lstSearchTrendsRes = new ArrayList<SearchTrendsModel>();
				
				for (int i = 6; i >= 0; i--) {
					
					String strNthINtervalDate = hmDatesIterator.get(i).trim();
					
					SearchTrendsModel searchTrendsModel =  new SearchTrendsModel();
					
					searchTrendsModel.setDate(strNthINtervalDate);
					searchTrendsModel.setMytopics(hmUserSearchTrends.get(strNthINtervalDate));
					searchTrendsModel.setTrendingtopics(hmOverallSearchTrends.get(strNthINtervalDate));
					lstSearchTrendsRes.add(searchTrendsModel);
				}
				
		return lstSearchTrendsRes;
	}
	
	static Map<Integer, String> getDatesforanInterval(int interval) {

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
