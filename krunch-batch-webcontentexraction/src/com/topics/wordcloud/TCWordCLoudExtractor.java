package com.topics.wordcloud;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVWriter;

public class TCWordCLoudExtractor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strTopicDataFileName = "E:/data/topics5.txt";

		TCWordCLoudExtractor topicContentExtractor = new TCWordCLoudExtractor();
		try {
			topicContentExtractor.iterateTopicUrls(strTopicDataFileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void iterateTopicUrls(String strTopicDataFileName) throws Exception {

		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			br = new BufferedReader(new FileReader(strTopicDataFileName));
			// ExtractURLContent topicContentExtractor = new ExtractURLContent();

			int counter = 0;
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] topic = line.split(cvsSplitBy);

				Map<String, String> hmTopicUrlandContent = getTopicURLandContent(topic[0]);

				HashMap<String, Integer> _hmWordCloudData = new HashMap<String, Integer>();

				for (Map.Entry<String, String> entry : hmTopicUrlandContent.entrySet()) {// Iterate One by One URL

					HashMap<String, String> hmWordCloud = getWordCount(entry.getKey()); // Get all the Word count for a
																						// single URL

					for (Map.Entry<String, String> entry2 : hmWordCloud.entrySet()) {

						// System.out.println(topic[0] + " :: " + entry2.getKey() + "::" +
						// entry2.getValue());

						if (_hmWordCloudData.containsKey(entry2.getKey())) {
							int value = _hmWordCloudData.get(entry2.getKey());
							Integer updatedKeyCount = value + 1;
							_hmWordCloudData.put(entry2.getKey(), updatedKeyCount);

						} else {

							_hmWordCloudData.put(entry2.getKey(), new Integer(entry2.getValue()));

						}

					}

				}

				HashMap<String, Integer> _hmSortedWordCloudData = sortByValue(_hmWordCloudData);

				List<HashMap<String, Integer>> myArrList = new ArrayList<HashMap<String, Integer>>();

				writeToCSV(_hmSortedWordCloudData, topic[0]);

				for (Map.Entry<String, Integer> entry2 : _hmSortedWordCloudData.entrySet()) {

					System.out.println(entry2.getKey() + "-" + entry2.getValue());

				}
				System.out.println("Topic Name [Count= " + topic[0] + "");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static Map<String, String> getTopicURLandContent(String topicName) throws SQLException {
		Statement stmt = null;

		Connection conn = com.learn2rise.contentextraction.datasource.DataSource.getConnection();
		stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT \"TopicOgUrl\",\"TopicOgUrlContent\" ,(ts_rank_cd(t1.\"TSV_FULL\",to_tsquery('"
						+ topicName + "'))) as topicrnk ,\"TopicUrlCount\"\r\n"
						+ "FROM (SELECT \"TopicOgUrl\", \"TopicOgUrlContent\", \"TopicOgTitle\",\"CreatedAt\",\"OrganizationEntities\",\"PersonEntities\",\r\n"
						+ "\"TSV_FULL\",\"TopicUrlCount\"	FROM \"TopicEntityData\", to_tsquery('" + topicName
						+ "') AS q  WHERE (\"TSV_FULL\" @@ q) \r\n"
						+ ") AS t1 where \"TopicOgUrlContent\" <> '' and  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '90 days' and	ts_rank_cd(t1.\"TSV_FULL\", to_tsquery('"
						+ topicName + "')  ) > .49\r\n"
						+ "and length(\"TopicOgTitle\") > 10 and  length(\"OrganizationEntities\") > 10  \r\n"
						+ "and  length(\"PersonEntities\") > 10  order by  \"TopicUrlCount\" desc ,\"topicrnk\" desc limit 1000 ");
		Map<String, String> hmTopicUrlandContent = new HashMap<String, String>();
		while (rs.next()) {

			String url = rs.getString(1);
			String text = rs.getString(2);

			hmTopicUrlandContent.put(url, text);

		}

		System.out.println("No of URLs for the Topic  : " + hmTopicUrlandContent.size());

		rs.close();
		stmt.close();
		conn.close();
		return hmTopicUrlandContent;
	}

	private static HashMap<String, String> getWordCount(String topicUrl) throws SQLException {
		Statement stmt = null;

		System.out.println("Enter Get Word COunt : " + topicUrl);
		topicUrl = topicUrl.replace("'", "''");

		Connection conn = com.learn2rise.contentextraction.datasource.DataSource.getConnection();

		stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT word,nentry FROM ts_stat($$ SELECT to_tsvector(t.\"TopicOgUrlContent\")  "
						+ "FROM \"TopicEntityData\" AS t where \"TopicOgUrl\"='" + topicUrl
						+ "'	$$)  order by nentry desc ;\r\n" + "");
		HashMap<String, String> hmTopicUrlandContent = new HashMap<String, String>();

		while (rs.next()) {

			String word = rs.getString(1);
			String count = rs.getString(2);

			hmTopicUrlandContent.put(word, count);

		}

		// System.out.println("Batch Size : " + hmTopicUrlandContent.size());

		rs.close();
		stmt.close();
		conn.close();
		return hmTopicUrlandContent;
	}

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}

		return temp;
	}

	private static void writeToCSV(HashMap<String, Integer> _hmSortedWordCloudData, String topicName)
			throws IOException {

		topicName = topicName.replace("&", "");
		topicName = topicName.replace("|", "");

		File file = new File("E:\\wordcloud\\" + topicName + ".csv");

		FileWriter outputfile = new FileWriter(file);

		CSVWriter writer = new CSVWriter(outputfile);

		// create a List which contains String array
		List<String[]> data = new ArrayList<String[]>();

		for (Map.Entry<String, Integer> entry2 : _hmSortedWordCloudData.entrySet()) {

			if (!Stopwords.isStopword(entry2.getKey())) {
				data.add(new String[] { entry2.getKey(), Integer.toString(entry2.getValue()) });

			}

		}

		writer.writeAll(data);

		// closing writer connection
		writer.close();
	}

}
