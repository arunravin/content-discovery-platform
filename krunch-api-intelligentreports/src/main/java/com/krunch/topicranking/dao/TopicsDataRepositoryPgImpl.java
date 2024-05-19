package com.krunch.topicranking.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.krunch.topicranking.entity.TopicRankingDataModel;
import com.krunch.topicranking.entity.TopicVideoDataModel;
import com.krunch.topicranking.entity.TopicsDataEnricher;
import com.krunch.topicranking.mapper.TopicContentDataMapper;
import com.krunch.topicranking.mapper.TopicDataEnricherMapper;
import com.krunch.topicranking.mapper.TopicYouTubeDataMapper;

@Repository
public class TopicsDataRepositoryPgImpl implements TopicsDataRepositoryCustom {

	final String TOPIC_QUEUE_INSERT_QUERY = "INSERT INTO public.\"User_Topic_Queue\"(\n"
			+ "	\"Topic_Url_Id\", \"User_Name\", \"CreatedAt\")\n" + "	VALUES (:topicurl, :username,:createdat);";

	final String TOPIC_ENGAGEMENT_INSERT_QUERY = "INSERT INTO public.\"User_Topic_Engagement\"(\n"
			+ "	\"Topic_Url_Id\", \"is_Liked\",\"User_Name\", \"CreatedAt\")\n"
			+ "	VALUES (:topicurl,:isliked, :username,:createdat);";

	final String TOPICS_READ_INSERT_QUERY = "INSERT INTO public.\"User_Topics_Read\"(\n"
			+ "	\"Topic_Url_Id\", \"User_Name\", \"CreatedAt\")\n" + "	VALUES (:topicurl, :username,:createdat);";

	public TopicsDataRepositoryPgImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	NamedParameterJdbcTemplate template;



	@Override
	public List<TopicRankingDataModel> findByTopicbyEntityType(String topicText , int timeIntervalfromToday) {

		String strTopicText = topicText.toLowerCase();

		TopicsQueryBuilder topicsQueryBuilder = new TopicsQueryBuilder();
		String strQueryforTopicSearch = topicsQueryBuilder.getQueryforExecution(strTopicText);
		Double dblRelevancyScore = topicsQueryBuilder.getTopicRelevancyToleranceLimit(strTopicText);

		String strTopicSearchSQL = "SELECT \"TopicOgUrl\",\"ArticlePublishedTime\",\"DateEntities\" ,\"TopicOgTitle\" ,\"TopicOgDescription\",\"TransformedText\",\n"
				+ "		(ts_rank_cd(t1.\"TSV_FULL\",to_tsquery('" + strQueryforTopicSearch + "')))\n"
				+ "		 as topicrnk,\"TopicUrlCount\" ,\"TopicOgImage\" ,\"OrganizationEntities\" , \"PersonEntities\" ,\"TitleEntities\" ,\n"
				+ "		\"CountryEntities\", \"CityEntities\" , \"DurationEntities\", \"MoneyEntities\" , \"TopicOgUrlContent\" ,"
				+ " \"TopicOutGoingLinksCount\" , \"TopicOutGoingLinksUrlSet\", \"CreatedAt\",\"TopicSourceUrl\"\n"
				+ "FROM \n"
				+ "	(SELECT \"TopicOgUrl\", \"ArticlePublishedTime\",\"DateEntities\", \"TopicOgTitle\" ,\"TopicOgDescription\", \"TransformedText\",\"TopicUrlCount\" ,\"TopicOgImage\" ,\n"
				+ "			 \"OrganizationEntities\" , \"PersonEntities\" ,\"TitleEntities\" ,\"CountryEntities\", \"CityEntities\" , \n"
				+ "			 \"DurationEntities\", \"MoneyEntities\",\"TopicOgUrlContent\","
				+ " \"TopicOutGoingLinksCount\" , \"TopicOutGoingLinksUrlSet\" ,\"CreatedAt\", \"TSV_FULL\",\"TopicSourceUrl\"\n"
				+ "	FROM \"TopicEntityData\", \n" + "		to_tsquery('" + strQueryforTopicSearch + "') AS q\n"
				+ "	  WHERE (\"TSV_FULL\" @@ q) \n" + "	) AS t1\n"
				+ "where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '"+timeIntervalfromToday+"  days' \n"
				+ "		and \"ArticlePublishedTime\" not like '%2020%'\n"
				+ "		and \"ArticlePublishedTime\" not like '%2019%' "
				+ "    and\n"
				+ " 		ts_rank_cd(t1.\"TSV_FULL\", to_tsquery('" + strQueryforTopicSearch + "')  ) > "
				+ dblRelevancyScore + " \n" + " 		and length(\"TopicOgTitle\") > 10\n"
				+ " 	and lower(\"TopicOgTitle\") not like '%coupon%' \n"
				+ " 	and lower(\"TopicOgTitle\") not like '%course%'\n"
				+ " 	and lower(\"TopicOgTitle\") not like '%certifi%'\n"
				+ " 	and lower(\"TopicOgTitle\") not like '%digitalscouting%'\n"
				+ " 	and lower(\"TopicOgTitle\") not like '%newsletter%'\n"
				+ "	and lower(\"TopicOgTitle\") not like '%for free%'\n"
				+ "	and lower(\"TopicOgTitle\") not like '%webinar%'\n"
				+ "	and lower(\"TopicOgTitle\") not like '%weekly notes%'\n"
				+ "	and lower(\"TopicOgTitle\") not like '%- edition%'\n"
				+ "	and lower(\"TopicOgTitle\") not like '%career%'\n" + "	  order by  \"TopicUrlCount\"  desc\n" + "";

		System.out.println(strTopicSearchSQL);

		List<TopicRankingDataModel> lstTopicDataModel = template.query(strTopicSearchSQL, new TopicContentDataMapper());

		Set<String> urlSet = new HashSet<>();
		List<TopicRankingDataModel> distinctTopicsbyUrl = lstTopicDataModel.stream()
				.filter(e -> urlSet.add(e.getOgUrl())).collect(Collectors.toList());


		return distinctTopicsbyUrl;
	}

	@Override
	public List<TopicsDataEnricher> enrichTopicsdata(String TopicText , int timeIntervalfromToday) {

		String strTopicText = TopicText.toLowerCase();

		TopicsQueryBuilder topicsQueryBuilder = new TopicsQueryBuilder();
		String strQueryforTopicSearch = topicsQueryBuilder.getQueryforExecution(strTopicText);
		Double dblRelevancyScore = topicsQueryBuilder.getTopicRelevancyToleranceLimit(strTopicText);

		String strTopicSearchSQL = 
		" select \"TopicUrl\" ,\"SharedCount\" , \"LikedCount\" ,\"FollowersCount\" , \"FollowingCount\" "
				+ " from \"Topics\" where \"TopicUrl\" in " + " (SELECT \"TopicSourceUrl\"\n" + "FROM \n"
				+ "	(SELECT \"TopicOgUrl\", \"ArticlePublishedTime\",\"DateEntities\", \"TopicOgTitle\" ,\"TopicOgDescription\", \"TransformedText\",\"TopicUrlCount\" ,\"TopicOgImage\" ,\n"
				+ "			 \"OrganizationEntities\" , \"PersonEntities\" ,\"TitleEntities\" ,\"CountryEntities\", \"CityEntities\" , \n"
				+ "			 \"DurationEntities\", \"MoneyEntities\",\"TopicOgUrlContent\","
				+ " \"TopicOutGoingLinksCount\" , \"TopicOutGoingLinksUrlSet\" ,\"CreatedAt\", \"TSV_FULL\",\"TopicSourceUrl\"\n"
				+ "	FROM \"TopicEntityData\", \n" + "		to_tsquery('" + strQueryforTopicSearch + "') AS q\n"
				+ "	  WHERE (\"TSV_FULL\" @@ q) \n" + "	) AS t1\n"
				+ "where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '"+timeIntervalfromToday+" days' \n"
				+ "		and \"ArticlePublishedTime\" not like '%2020%'\n"
				+ "		and \"ArticlePublishedTime\" not like '%2019%' " 
				+ " and	ts_rank_cd(t1.\"TSV_FULL\", to_tsquery('" + strQueryforTopicSearch + "')  ) > "
				+ dblRelevancyScore + " \n" + " 		and length(\"TopicOgTitle\") > 10\n"
				+ " 	and lower(\"TopicOgTitle\") not like '%coupon%' \n"
				+ " 	and lower(\"TopicOgTitle\") not like '%course%'\n"
				+ " 	and lower(\"TopicOgTitle\") not like '%certifi%'\n"
				+ " 	and lower(\"TopicOgTitle\") not like '%digitalscouting%'\n"
				+ " 	and lower(\"TopicOgTitle\") not like '%newsletter%'\n"
				+ "		and lower(\"TopicOgTitle\") not like '%for free%'\n"
				+ "		and lower(\"TopicOgTitle\") not like '%webinar%'\n"
				+ "		and lower(\"TopicOgTitle\") not like '%weekly notes%'\n"
				+ "		and lower(\"TopicOgTitle\") not like '%- edition%'\n"
				+ "		and lower(\"TopicOgTitle\") not like '%career%'\n" + "	 "
						+ "	 order by  \"TopicUrlCount\"  desc ) \n"
				+ "";

		System.out.println(strTopicSearchSQL);

		List<TopicsDataEnricher> lstTopicDataEnricher = template.query(strTopicSearchSQL,
				new TopicDataEnricherMapper());

		return lstTopicDataEnricher;
	}


}
