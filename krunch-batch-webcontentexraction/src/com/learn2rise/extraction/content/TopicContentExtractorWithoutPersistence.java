package com.learn2rise.extraction.content;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.learn2rise.contentextraction.dao.TopicsDataBatchUpdateDAO;
import com.learn2rise.extraction.content.model.TopicDataModel;
import com.learn2rise.extraction.mapping.MapTopicDatatoModel;

public class TopicContentExtractorWithoutPersistence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strTopicDataFileName = "C:/data/trrep.csv";

		TopicContentExtractorWithoutPersistence topicContentExtractor = new TopicContentExtractorWithoutPersistence();
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
		TopicDataModel topicDataModel = new TopicDataModel();

		try {

			br = new BufferedReader(new FileReader(strTopicDataFileName));
			ExtractURLContent topicContentExtractor = new ExtractURLContent();

			Map<String, String> hmTopicContentandMetadataInfo = null;
			List<TopicDataModel> dataContainer = new ArrayList<TopicDataModel>();

			int counter = 0;
			while ((line = br.readLine()) != null) {

				// use comma as separator
				String[] topic = line.split(cvsSplitBy);

				System.out.println("Topic URL [Count= " + topic[0] );

				hmTopicContentandMetadataInfo = topicContentExtractor.getURLContent(topic[0]);
		
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

}
