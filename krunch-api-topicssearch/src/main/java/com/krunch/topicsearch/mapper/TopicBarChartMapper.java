package com.krunch.topicsearch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicsearch.entity.TopicBarChartData;
import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicPieChartData;

public class TopicBarChartMapper implements RowMapper<TopicBarChartData>{

	@Override
	public TopicBarChartData mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TopicBarChartData topicBarChartData = new TopicBarChartData();
		
		topicBarChartData.setData(rs.getInt("data"));
		topicBarChartData.setLabels(rs.getString("labels"));
		
		
		return topicBarChartData;
	}
	
	

}
