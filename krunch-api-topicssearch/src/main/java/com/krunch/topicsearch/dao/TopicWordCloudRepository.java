package com.krunch.topicsearch.dao;

import java.util.List;

import com.krunch.topicsearch.entity.CloudData;


public interface TopicWordCloudRepository  {
	
	
	List<CloudData> getTopicWordCloudData(String topicName);
	
	List<CloudData> getPersonTopicWordCloudData(String topicName);
	
	List<String> getTopicNameWordCloudData(String topicName);
	
	List<String> getTopicPersonWordCloudData(String topicName);
	
	}

