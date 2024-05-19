package com.krunch.topicranking.algo;

import java.util.StringTokenizer;

import com.krunch.topicranking.entity.TopicMetaData;
import com.krunch.topicranking.entity.TopicRankingDataModel;

public class CalcArticleContentQuality extends AbsTopicRankingAlgo {

	@Override
	public boolean process(TopicRankingDataModel topicDataModel, TopicMetaData topicMetaData) {

		double dblContentWeightage = 0.0;
		int noOfWordsinDocument = countWordsUsingStringTokenizer(topicDataModel.getOgUrlContent());
		dblContentWeightage= (double) (noOfWordsinDocument / 100);
		
		dblContentWeightage = dblContentWeightage + checkDocumentEntities(topicDataModel);

		topicDataModel.setContentWeightScore(dblContentWeightage);

		//System.out.println(" Content size  Score : "+dblContentWeightage);
		return checkNextHandler(topicDataModel, topicMetaData);

	}

	public static int countWordsUsingStringTokenizer(String paragraph) {
		
		if (paragraph == null || paragraph.isEmpty()) {
					return 0;
		}
		
		StringTokenizer tokens = new StringTokenizer(paragraph);
	    int noOfWordsinDocument = tokens.countTokens();
		 return noOfWordsinDocument;
	}
	
	static double checkDocumentEntities(TopicRankingDataModel topicDataModel) {

		double docEntitiesScore = 0.0;

		String strEntities = topicDataModel.getMoneyEntities() + "|" + topicDataModel.getOrganizationEntities() + "|"
				+ topicDataModel.getPersonEntities();

		docEntitiesScore = (double) strEntities.split("\\|").length * 0.25;

		return docEntitiesScore;

	}

}
