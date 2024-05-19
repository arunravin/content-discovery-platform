package com.krunch.topicsearch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicsearch.entity.CloudData;

public class TopicWordCloudMapper implements RowMapper<CloudData>{

	@Override
	public CloudData mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CloudData topicWordCloudData = new CloudData();
		
		topicWordCloudData.setText(rs.getString("EntityName"));
		topicWordCloudData.setWeight(rs.getInt("Count"));
		
		return topicWordCloudData;
	}
	
}
