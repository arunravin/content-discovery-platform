package com.krunch.topicranking.algo;

import java.net.MalformedURLException;
import java.net.URL;

import com.krunch.topicranking.dao.TopicsQueryBuilder;
import com.krunch.topicranking.entity.TopicMetaData;
import com.krunch.topicranking.entity.TopicRankingDataModel;

public class CalcArticleOutBoundLinksStrength extends AbsTopicRankingAlgo {

	String topicName;
	TopicsQueryBuilder topicsQueryBuilder = new TopicsQueryBuilder();

	CalcArticleOutBoundLinksStrength(String topicName) {
		this.topicName = topicName;
	}

	@Override
	public boolean process(TopicRankingDataModel topicRankingDataModel, TopicMetaData topicMetaData) {
		// TODO Auto-generated method stub
		//System.out.println(
		//		"*************************************Enter CalculateArticleOutBoundLinkStrength *************************************: ");
		topicRankingDataModel = calculateArticleOutBoundLinkStrength(topicRankingDataModel,topicMetaData);
		return checkNextHandler(topicRankingDataModel, topicMetaData);
	}

	private TopicRankingDataModel calculateArticleOutBoundLinkStrength(TopicRankingDataModel topicRankingDataModel,TopicMetaData topicMetaData ) {

		String strOutGoingLinks = topicRankingDataModel.getTopicOutGoingLinksUrlSet();
		
		System.out.println(topicMetaData.getTopicName());
		System.out.println(topicMetaData.getTopicKeywords());
		
		String[] topicKeyWords = topicMetaData.getTopicKeywords().split("\\|");
		URL url = null;
		double outBoundLinksScore = 0.00;

		if (strOutGoingLinks != null && strOutGoingLinks.length() > 25) {
			String[] arrOutGoingLink = strOutGoingLinks.split("\\|");

			for (int i = 0; i < arrOutGoingLink.length; i++) {

				// System.out.println(arrOutGoingLink[i]);

				try {
					url = new URL(arrOutGoingLink[i]);
				} catch (MalformedURLException e) {
				//	e.printStackTrace();
				}

				if (url.getPath() != null && url.getPath().split("/").length - 1 > 1) {

					if (url.getPath().split("-").length - 1 > 3 || url.getPath().split("_").length - 1 > 3) {

						outBoundLinksScore = outBoundLinksScore + 0.5;

						// System.out.println("OutBound Links containes valid titles : " +
						// outBoundLinksScore);
					}

					for (String topicKeyWord : topicKeyWords) {

						if (url.getPath().toLowerCase().contains(topicKeyWord)) {

							outBoundLinksScore = outBoundLinksScore + 0.5;
							// System.out.println("OutBound Links containes Keywords : " + outBoundLinksScore);

							break;
						}
					}

				}

			}

			topicRankingDataModel.setArticleOutBoundLinkScore(outBoundLinksScore);
			topicRankingDataModel.setPipelineStatus("1");
		//	System.out.println(topicRankingDataModel.getOgUrl() + "\r\n : OutBound Links Score : " + outBoundLinksScore);

		} else {
		//	System.out.println(topicRankingDataModel.getOgUrl() + "OutGoingLinkFactor is 0");
		}

		return topicRankingDataModel;

	}

}
