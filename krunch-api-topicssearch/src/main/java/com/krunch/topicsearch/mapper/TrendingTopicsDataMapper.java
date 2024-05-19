package com.krunch.topicsearch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicRecommendations;

public class TrendingTopicsDataMapper implements RowMapper<TopicRecommendations>  {

	@Override
	public TopicRecommendations mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TopicRecommendations topicrecommendations = new TopicRecommendations();
		
		String strTitle = rs.getString("TopicOgTitle");
		String strTopicURL = rs.getString("TopicOgUrl");
		String strTopicOgImage = rs.getString("TopicOgImage");
		
		topicrecommendations.setName(strTitle);
		topicrecommendations.setUrl(strTopicURL);
		topicrecommendations.setType(strTopicOgImage);
		
		return topicrecommendations;
		
	}

}
