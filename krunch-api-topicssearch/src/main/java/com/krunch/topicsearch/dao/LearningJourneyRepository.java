package com.krunch.topicsearch.dao;

import java.util.List;
import java.util.Map;

import com.krunch.topicsearch.entity.TopicBarChartData;
import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicPieChartData;
import com.krunch.topicsearch.entity.TopicRecommendations;


public interface LearningJourneyRepository  {
	
	List<TopicPieChartData> getUserPieChartData(String userName);
	
	List<TopicDataModel> getUserTopicQueue(String userName);
	
	List<TopicRecommendations> getUserTopicRecommendations(String topicTitle,int noOfTopics);
	
	List<TopicBarChartData> getUserRecentTopicQueueData(String userName);
	
	List<TopicBarChartData> getUserBarChartData(String userName);
	
	List<TopicRecommendations> getUserResearchTopics(String userName);
}

