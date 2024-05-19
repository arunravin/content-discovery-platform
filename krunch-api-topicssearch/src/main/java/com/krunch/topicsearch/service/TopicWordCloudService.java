package com.krunch.topicsearch.service;

import java.util.List;
import java.util.Map;

import com.krunch.topicsearch.entity.CloudData;
import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicRecommendations;
import com.krunch.topicsearch.recommendations.json.Data;

public interface TopicWordCloudService {
	
	  
	   public List<CloudData> getTopicsWordCloud(String topicName);
	   
	   public List<CloudData> getPersonTopicsWordCloud(String topicName);
	   
	   public List<CloudData> getTopicNameWordCloud(String topicName);
	   
	   List<CloudData> getPersonWordCloud(String topicName);
	   
	
	}
