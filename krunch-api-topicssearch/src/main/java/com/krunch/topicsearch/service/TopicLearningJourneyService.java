package com.krunch.topicsearch.service;

import java.util.List;
import java.util.Map;

import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicRecommendations;
import com.krunch.topicsearch.recommendations.json.Data;

public interface TopicLearningJourneyService {
	
	   public String getUserLearningEngagements(String userName);
	   
	   public String getUserActivity(String userName);
	   
	   public String getUserResearchTopics(String userName);
	   
	  
	   public Map<String, Object> getUserAchievements(String userName);
	   
	   public String getUserRecommendations(String topicTitle);
	   
	   public String getMyTopicsWordCloud(String userName);
	   
	   public void clearUserCache(String userName);
	
	}
