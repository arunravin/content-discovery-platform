package com.krunch.topicranking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicranking.entity.TopicRankingDataModel;
import com.krunch.topicranking.entity.TopicVideoDataModel;

public class TopicYouTubeDataMapper implements RowMapper<TopicVideoDataModel> {

	@Override
	public TopicVideoDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TopicVideoDataModel topicDataModel = new TopicVideoDataModel();
		
		String strTitle = rs.getString("TopicOgTitle");
		
		if(strTitle!=null && strTitle.contains("|")) {
			
			strTitle = strTitle.substring(0,strTitle.indexOf("|")-1);
			
			topicDataModel.setOgTitle(strTitle);
		} else {
			
			topicDataModel.setOgTitle(strTitle);
		}
		
		if(strTitle!=null && strTitle.length()>50) {
			
			strTitle = strTitle.substring(0,50);
			
			topicDataModel.setOgTitle(strTitle);
		} 
		
		
		
		topicDataModel.setOgUrl(rs.getString("TopicOgUrl"));
		topicDataModel.setUrlCount(rs.getInt("TopicUrlCount"));
		
			
		return topicDataModel;
	}

}
