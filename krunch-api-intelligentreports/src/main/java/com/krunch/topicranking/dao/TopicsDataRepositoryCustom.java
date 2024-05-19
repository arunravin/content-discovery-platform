package com.krunch.topicranking.dao;

import java.util.List;
import java.util.Map;

import com.krunch.topicranking.entity.TopicRankingDataModel;
import com.krunch.topicranking.entity.TopicsDataEnricher;


public interface TopicsDataRepositoryCustom  {
	
	
		
	List<TopicRankingDataModel> findByTopicbyEntityType(String topicText,int timeIntervalfromToday);
	
	List<TopicsDataEnricher> enrichTopicsdata(String TopicText , int timeIntervalfromToday);
	
	
}

