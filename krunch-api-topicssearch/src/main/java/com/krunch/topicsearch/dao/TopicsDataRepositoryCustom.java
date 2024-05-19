package com.krunch.topicsearch.dao;

import java.util.Map;


public interface TopicsDataRepositoryCustom  {
	
	Map<String, Object> findByTopicText(String TopicText);
	
	Map<String, Object> findTrendingTopics(String TopicText);
	
	Map<String, Object> findByTopicbyReportType(String TopicText);
	
	Map<String, Object> findByTopicbyEntityType(String TopicText);
	
	Map<String, Object> findTrendingYouTubeVideos(String TopicText);
	
	String addTopicToQueue( String username,String topicurl );
	
	String topicRead( String username,String topicurl );
	
	String likeTopic( String username,String topicurl,String isLiked );
	
	String unLikeTopic( String username,String topicurl ,String isLiked);

	String storeSharedTopicEvent(String username, String topicurl,String socialMediaName);

	
}

