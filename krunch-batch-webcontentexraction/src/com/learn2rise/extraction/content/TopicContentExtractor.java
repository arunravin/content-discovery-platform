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

public class TopicContentExtractor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strTopicDataFileName = "C:/data/gcr.csv";

		TopicContentExtractor topicContentExtractor = new TopicContentExtractor();
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

				System.out.println("Raw Topic URL [Count= " + topic[0] + " , Raw TransformedText=" + topic[1]
						+ " , TopicsURL=" + topic[2] + "]");

				hmTopicContentandMetadataInfo = topicContentExtractor.getURLContent(topic[2]);
                Thread.sleep(61000);
//				System.out.println("Exit Process without insertingin DB");
//				++counter;
//				if(counter ==10) System.exit(1);

				// System.out.println("Printing the Keys and Values from Map $$$$$$"+
				// Arrays.asList(hmTopicContentandMetadataInfo));
				if (hmTopicContentandMetadataInfo != null)
					topicDataModel = new MapTopicDatatoModel().convertTopicDatatoModel(hmTopicContentandMetadataInfo,
							Integer.parseInt(topic[0]), topic[1], topic[2]);

				if (dataContainer == null)
					dataContainer = new ArrayList<TopicDataModel>();

				if (topicDataModel != null) {

					if (topicDataModel.getOgTitle() != null && topicDataModel.getOgUrl() == null) {

						topicDataModel.setOgUrl(topic[2]);

					}

					if(topicDataModel.getOgUrl() != null)	dataContainer.add(topicDataModel);
				}
				//dataContainer.add(topicDataModel);

				if (dataContainer != null)
					System.out.println("Data Container Size " + dataContainer.size());

				if (dataContainer != null && dataContainer.size() > 0) {

					boolean updatedTopic = TopicsDataBatchUpdateDAO.checkandUpdateTopicCount(topicDataModel.getOgUrl(),
							topicDataModel.getUrlCount());

					if (!updatedTopic) {
						TopicsDataBatchUpdateDAO.parameterizedBatchUpdate(dataContainer);
					} else {
						System.out.println(
								"Topic Already exists .. " + updatedTopic + " :::" + topicDataModel.getOgUrl());
					}
					dataContainer = null;
				}

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
