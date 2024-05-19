package com.krunch.topicsearch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicPieChartData;

public class TopicPieChartMapper implements RowMapper<TopicPieChartData>{

	@Override
	public TopicPieChartData mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TopicPieChartData topicPieChartData = new TopicPieChartData();
		
		
		
		topicPieChartData.setTcount(rs.getInt("tcount"));
		topicPieChartData.setEngagementType(rs.getString("engagementtype"));
		
		return topicPieChartData;
	}
	
	

}
