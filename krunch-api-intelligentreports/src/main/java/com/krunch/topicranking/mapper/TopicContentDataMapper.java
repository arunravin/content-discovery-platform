package com.krunch.topicranking.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicranking.entity.TopicRankingDataModel;

public class TopicContentDataMapper implements RowMapper<TopicRankingDataModel> {

	@Override
	public TopicRankingDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TopicRankingDataModel topicDataModel = new TopicRankingDataModel();
		
		topicDataModel.setOgTitle(rs.getString("TopicOgTitle"));
		topicDataModel.setOgDescription(rs.getString("TopicOgDescription"));
		topicDataModel.setOgUrl(rs.getString("TopicOgUrl"));
		topicDataModel.setOgImage(rs.getString("TopicOgImage"));
		topicDataModel.setUrlCount(rs.getInt("TopicUrlCount"));
		
		topicDataModel.setOrganizationEntities(rs.getString("OrganizationEntities"));
		topicDataModel.setPersonEntities(rs.getString("PersonEntities"));
		topicDataModel.setTitleEntities(rs.getString("TitleEntities"));
		topicDataModel.setCountryEntities(rs.getString("CountryEntities"));
		topicDataModel.setCityEntities(rs.getString("CityEntities"));
		topicDataModel.setDurationEntities(rs.getString("DurationEntities"));
		topicDataModel.setDateEntities(rs.getString("DateEntities"));
		topicDataModel.setMoneyEntities(rs.getString("MoneyEntities"));
		
		topicDataModel.setTopicSourceUrl(rs.getString("TopicSourceUrl"));
		topicDataModel.setArticlePublishedTime(rs.getString("ArticlePublishedTime"));
		topicDataModel.setTopicOutGoingLinksCount(rs.getInt("TopicOutGoingLinksCount"));
		topicDataModel.setTopicOutGoingLinksUrlSet(rs.getString("TopicOutGoingLinksUrlSet"));
		topicDataModel.setOgUrlContent(rs.getString("TopicOgUrlContent"));
		return topicDataModel;
		
	}

}
