package com.krunch.topicsearch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicRecommendations;

public class TopicRecommendationsDataMapper implements RowMapper<TopicRecommendations>  {

	@Override
	public TopicRecommendations mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TopicRecommendations topicrecommendations = new TopicRecommendations();
		
		String strTitle = rs.getString("TopicOgTitle");
		String strDescription= rs.getString("TopicOgDescription");
		String strTopicURL = rs.getString("TopicOgUrl");
		
		topicrecommendations.setName(strTitle);
		topicrecommendations.setType(strDescription);
		topicrecommendations.setUrl(strTopicURL);
		
		//System.out.println("Mapper Title : " +strTitle );
		
		return topicrecommendations;
		
	}

}
