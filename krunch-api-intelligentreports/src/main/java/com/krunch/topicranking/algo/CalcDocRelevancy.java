package com.krunch.topicranking.algo;

import com.krunch.topicranking.entity.TopicMetaData;
import com.krunch.topicranking.entity.TopicRankingDataModel;

public class CalcDocRelevancy extends AbsTopicRankingAlgo {

	@Override
	public boolean process(TopicRankingDataModel topicDataModel, TopicMetaData topicMetaData) {
	//	System.out.println("TACalculatePageMetaDataWeightage");
		
		if(topicDataModel.getOgTitle().contains(topicMetaData.getTopicName()) || 
				topicDataModel.getOgDescription().contains(topicMetaData.getTopicName()) ) {
			
			topicDataModel.setDocumentRelevancy(1);
			
			
		}
		
		return checkNextHandler(topicDataModel, topicMetaData);
	}

}
