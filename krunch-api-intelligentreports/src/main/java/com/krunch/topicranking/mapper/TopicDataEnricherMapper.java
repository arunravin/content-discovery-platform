package com.krunch.topicranking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicranking.entity.TopicsDataEnricher;

public class TopicDataEnricherMapper implements RowMapper<TopicsDataEnricher> {

	@Override
	public TopicsDataEnricher mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TopicsDataEnricher topicDataEnricher = new TopicsDataEnricher();
		
		topicDataEnricher.setTopicUrl(rs.getString("TopicUrl"));
		topicDataEnricher.setSharedCount(rs.getInt("SharedCount"));
		topicDataEnricher.setLikedCount( rs.getInt("LikedCount"));
		topicDataEnricher.setFollowersCount(rs.getInt("FollowersCount"));
		topicDataEnricher.setFollowingCount(rs.getInt("FollowingCount"));
		
		return topicDataEnricher;
		
	}

}
