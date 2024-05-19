package com.krunch.topicranking.algo;

import java.util.ArrayList;
import java.util.List;

import com.krunch.topicranking.entity.TopicMetaData;
import com.krunch.topicranking.entity.TopicRankingDataModel;

public abstract class AbsTopicRankingAlgo {

	private AbsTopicRankingAlgo nextHandler;
	public TopicRankingDataModel _topicRankingData;
	public List<TopicRankingDataModel> lstTopicRankingDataModel = new ArrayList<TopicRankingDataModel>();

	public TopicRankingDataModel _topicRankingResult;

	
	
	public AbsTopicRankingAlgo linkWith(AbsTopicRankingAlgo nextHandler) {

		this.nextHandler = nextHandler;
		return nextHandler;

	}

	public abstract boolean process(TopicRankingDataModel topicDataModel , TopicMetaData topicRanking);

	protected boolean checkNextHandler(TopicRankingDataModel topicDataModel, TopicMetaData topicRanking) {

		if (nextHandler == null) {

			return true;
		}

		return nextHandler.process(topicDataModel,topicRanking);
	}

	
	public TopicRankingDataModel get_topicRankingResult() {
		return _topicRankingResult;
	}

	public void set_topicRankingResult(TopicRankingDataModel _topicRankingResult) {
		this._topicRankingResult = _topicRankingResult;
	//		System.out.println("Result Getting Addedd ...*****************************"+_topicRankingResult.toString());
	}
	
	public TopicRankingDataModel getFinalRankingResultforTopics(){
		
		return this._topicRankingResult;
	}

}