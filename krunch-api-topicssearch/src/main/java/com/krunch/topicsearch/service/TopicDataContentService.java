package com.krunch.topicsearch.service;

import java.util.List;
import java.util.Map;

import com.krunch.topicsearch.entity.TopicDataModel;

public interface TopicDataContentService {
	
	   public  List<TopicDataModel>  findByTopicText(String TopicText);
		
		public Map<String, Object> findByTopicbyReportType(String TopicText) ;
		
		public Map<String, Object> findTrendingTopics(String TopicText) ;
		
		public Map<String, Object> findByTopicbyEntityType(String TopicText) ;
		
		public Map<String, Object> findTrendingYouTubeVideos(String TopicText) ;
	
		public String addTopicToQueue(String username,String topicurl);
		
		public String storeSharedTopicEvent(String username,String topicurl, String socialMediaName);
		
		public String topicRead(String username,String topicurl);
		
		public String likeTopic(String username,String topicurl,String isliked);
		
		public String unLikeTopic(String username,String topicurl,String isliked);
}
