package com.krunch.topicsearch.dao;

import java.util.List;

import com.krunch.topicsearch.entity.SearchKeyWordData;
import com.krunch.topicsearch.entity.SearchTrendsModel;
import com.krunch.topicsearch.vo.SeaarchKeyword;


public interface KrunchAnalyticsRepository  {
	
	
	List<String> getKrunchSearchKeywordsData();
	
	
	String postSearchKeyWords(SeaarchKeyword searckKeyWordVO);

	List<SearchTrendsModel> getKrunchSearchTrendsData(String userName);
	
	}

