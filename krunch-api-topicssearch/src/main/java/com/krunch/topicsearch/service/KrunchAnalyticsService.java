package com.krunch.topicsearch.service;

import java.util.List;
import java.util.Map;

import com.krunch.topicsearch.entity.CloudData;
import com.krunch.topicsearch.entity.SearchKeyWordData;
import com.krunch.topicsearch.entity.SearchTrendsModel;
import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicRecommendations;
import com.krunch.topicsearch.recommendations.json.Data;
import com.krunch.topicsearch.vo.SeaarchKeyword;

public interface KrunchAnalyticsService {
	
	  
	List<String> getKrunchSearchKeywordsData();
	
	List<SearchKeyWordData> getUsersSearchKeywordsData(String userName);
	
	String postSearchKeyWords(SeaarchKeyword searckKeyWordVO);
	   
	List<SearchTrendsModel> getKrunchSearchTrendsData(String userName);
	
	
	}
