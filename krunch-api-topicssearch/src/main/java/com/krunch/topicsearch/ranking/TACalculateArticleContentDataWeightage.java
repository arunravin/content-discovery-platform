package com.krunch.topicsearch.ranking;

import java.util.StringTokenizer;

import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicMetaData;

public class TACalculateArticleContentDataWeightage  {


	public double calculateContentWeight(TopicDataModel topicDataModel, TopicMetaData topicMetaData) {

		double dblContentWeightage = 0.0;
		
		dblContentWeightage = dblContentWeightage + checkDocumentEntities(topicDataModel);

		
		//System.out.println(" Content size  Score : "+dblContentWeightage);
		return dblContentWeightage;

	}

	public static int countWordsUsingStringTokenizer(String paragraph) {
		
		if (paragraph == null || paragraph.isEmpty()) {
					return 0;
		}
		
		StringTokenizer tokens = new StringTokenizer(paragraph);
	    int noOfWordsinDocument = tokens.countTokens();
		 return noOfWordsinDocument;
	}
	
	static double checkDocumentEntities(TopicDataModel topicDataModel) {

		double docEntitiesScore = 0.0;

		String strEntities = topicDataModel.getEntities();

		docEntitiesScore = (double) strEntities.split("\\|").length * 0.25;

		return docEntitiesScore;

	}

}
