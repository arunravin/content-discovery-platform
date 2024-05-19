package com.krunch.topicsearch.dao;

import java.sql.Timestamp;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicRecommendations;
import com.krunch.topicsearch.entity.TopicVideoDataModel;
import com.krunch.topicsearch.mapper.TopicContentDataMapper;
import com.krunch.topicsearch.mapper.TopicRecommendationsDataMapper;
import com.krunch.topicsearch.mapper.TopicSearchContentDataMapper;
import com.krunch.topicsearch.mapper.TopicYouTubeDataMapper;
import com.krunch.topicsearch.mapper.TrendingTopicsDataMapper;
import com.krunch.topicsearch.querybuilder.TopicsQueryBuilder;


@Repository
public class TopicsDataRepositoryPgImpl implements TopicsDataRepositoryCustom {

	Log log = LogFactory.getLog(getClass());

	
	final String TOPIC_QUEUE_INSERT_QUERY = "INSERT INTO public.\"User_Topic_Queue\"(\n" + 
			"	\"Topic_Url_Id\", \"User_Name\", \"CreatedAt\")\n" + 
			"	VALUES (:topicurl, :username,:createdat);";

	final String TOPIC_ENGAGEMENT_INSERT_QUERY = "INSERT INTO public.\"User_Topic_Engagement\"(\n" + 
			"	\"Topic_Url_Id\", \"is_Liked\",\"User_Name\", \"CreatedAt\")\n" + 
			"	VALUES (:topicurl,:isliked, :username,:createdat);";
	
	final String TOPICS_READ_INSERT_QUERY = "INSERT INTO public.\"User_Topics_Read\"(\n" + 
			"	\"Topic_Url_Id\", \"User_Name\", \"CreatedAt\")\n" + 
			"	VALUES (:topicurl, :username,:createdat);";

	final String TOPICS_SHARED_INSERT_QUERY = "INSERT INTO public.\"User_Topics_Shared\"(\n" + 
			"	\"Topic_Url_Id\", \"User_Name\", \"CreatedAt\" ,\"Social_Media_Name\")\n" + 
			"	VALUES (:topicurl, :username,:createdat,:socialmedianame);";


	
	public TopicsDataRepositoryPgImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	NamedParameterJdbcTemplate template;

	@Override
	public Map<String, Object> findByTopicText(String strTopicName) {
		// TODO Auto-generated method stub
		String strTopicText = strTopicName.toLowerCase();
		
				
		TopicsQueryBuilder topicsQueryBuilder = new TopicsQueryBuilder();
		String strQueryforTopicSearch = topicsQueryBuilder.getQueryforExecution(strTopicText);
		
	//	String strQueryforTopicSearch = 
	//			"select * from \"VW_BusinessTech_Topic_Data\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '2 months'" ;

		log.info(strQueryforTopicSearch);
		List<TopicDataModel> lstTopicDataModel = template.query(strQueryforTopicSearch, new TopicContentDataMapper());

		Set<String> urlSet = new HashSet<>();
		List<TopicDataModel> distinctTopicsbyUrl = lstTopicDataModel.stream().filter(e -> urlSet.add(e.getOgUrl()))
				.collect(Collectors.toList());

		Map<String, Object> dataMap = null;

		dataMap = new HashMap<String, Object>();
		dataMap.put("data", distinctTopicsbyUrl);
		return dataMap;
	}
	
	
	@Override
	public Map<String, Object> findTrendingTopics(String TopicText) {
		
		String topTrendsQuery = "(select \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\" ,topicrnk,\n" + 
				" \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" from\n" + 
				"(SELECT \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\", \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" ,\n" + 
				" ts_rank_cd(t1.\"TSV_FULL\", plainto_tsquery('"+TopicText+"')) as topicrnk\n" + 
				"FROM (  SELECT \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\", \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" , \"TSV_FULL\"\n" + 
				"          FROM \"TopicEntityData\", plainto_tsquery('"+TopicText+"') AS q\n" + 
				"  WHERE (\"TSV_FULL\" @@ q)\n" + 
				") AS t1 where\n" + 
				" lower(\"TopicOgTitle\") not like '%coupon%' and lower(\"TopicOgTitle\") not like '%course%'\n" + 
				" and lower(\"TopicOgTitle\") not like '%certifi%'\n" + 
				"  ) as t2  where  length(\"TopicOgTitle\") > 10 and \"TopicUrlCount\" > 3 order by topicrnk desc limit 6)\n" + 
				"  union \n" + 
				"(  select \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\" ,topicrnk,\"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\"  from\n" + 
				"(SELECT \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\", \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" ,\n" + 
				" ts_rank_cd(t1.\"TSV_FULL\", plainto_tsquery('"+TopicText+"')) as topicrnk\n" + 
				"FROM (  SELECT \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\" , \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" , \"TSV_FULL\"\n" + 
				"          FROM \"TopicEntityData\", plainto_tsquery('"+TopicText+"') AS q\n" + 
				"  WHERE (\"TSV_FULL\" @@ q)\n" + 
				") AS t1 where\n" + 
				" lower(\"TopicOgTitle\") not like '%coupon%' and lower(\"TopicOgTitle\") not like '%course%'\n" + 
				" and lower(\"TopicOgTitle\") not like '%certifi%'\n" + 
				"  ) as t2  where  length(\"TopicOgTitle\") > 10 and topicrnk > .5 and \"TopicUrlCount\" > 2\n" + 
				" order by \"CreatedAt\"  desc limit 6)\n" + 
				"  union \n" + 
				" (select \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\" ,topicrnk,\n" + 
				"  \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\"  from\n" + 
				"(SELECT \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\" , \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" ,\n" + 
				" ts_rank_cd(t1.\"TSV_FULL\", plainto_tsquery('"+TopicText+"')) as topicrnk\n" + 
				"FROM (  SELECT \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\" , \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" , \"TSV_FULL\"\n" + 
				"          FROM \"TopicEntityData\", plainto_tsquery('"+TopicText+"') AS q\n" + 
				"  WHERE (\"TSV_FULL\" @@ q)\n" + 
				") AS t1 where\n" + 
				" lower(\"TopicOgTitle\") not like '%coupon%' and lower(\"TopicOgTitle\") not like '%course%'\n" + 
				" and lower(\"TopicOgTitle\") not like '%certifi%'\n" + 
				"  ) as t2  where  length(\"TopicOgTitle\") > 10 and topicrnk > .5 order by \"TopicUrlCount\"  desc limit 6)\n" + 
				"  union \n" + 
				"  (select \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\" ,topicrnk,\n" + 
				"   \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" from\n" + 
				"(SELECT \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\", \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" ,\n" + 
				" ts_rank_cd(t1.\"TSV_FULL\", plainto_tsquery('"+TopicText+"')) as topicrnk\n" + 
				"FROM (  SELECT \"TopicOgTitle\",\"TopicOgUrl\", \"TopicOgImage\", \"CreatedAt\" , \"ArticlePublishedTime\",\"TopicUrlCount\" , \"TSV_FULL\"\n" + 
				"          FROM \"TopicEntityData\", plainto_tsquery('"+TopicText+"') AS q\n" + 
				"  WHERE (\"TSV_FULL\" @@ q)\n" + 
				") AS t1 where\n" + 
				" lower(\"TopicOgTitle\") not like '%coupon%' and lower(\"TopicOgTitle\") not like '%course%'\n" + 
				" and lower(\"TopicOgTitle\") not like '%certifi%'\n" + 
				"  ) as t2  where  length(\"TopicOgTitle\") > 10 \n" + 
				"   and \"ArticlePublishedTime\" is not null \n" + 
				" and \"TopicUrlCount\"  > 3 and topicrnk > .30 order by \"CreatedAt\" desc , topicrnk desc limit 6)\n" + 
				"  ";
		
		List<TopicRecommendations> lstTopicDataModel = template.query(topTrendsQuery, new TrendingTopicsDataMapper());

		Set<String> urlSet = new HashSet<>();
		List<TopicRecommendations> distinctTopicsbyUrl = lstTopicDataModel.stream().filter(e -> urlSet.add(e.getUrl()))
				.collect(Collectors.toList());

		
		Map<String, Object> dataMap = null;
		dataMap = new HashMap<String, Object>();
		dataMap.put("data", distinctTopicsbyUrl);
		return dataMap;

		
		
	}

	@Override 
	public Map<String, Object> findByTopicbyEntityType(String strTopicName ) {
		// TODO Auto-generated method stub
		String strTopicText = strTopicName.toLowerCase();
		
		log.info("Index of "+strTopicName.indexOf('$'));
		
		if(strTopicName.indexOf('$')>=0){
			
			strTopicText= strTopicName.substring(strTopicName.indexOf('$')+1,strTopicName.length());
			
		} 
		
		String strFullTextSearch = "\n" + 
				"SELECT \"TopicOgUrl\",  \"TopicOgTitle\" ,\"TopicOgDescription\", \"TopicUrlCount\" ,\n" + 
				"\"TopicOgImage\" ,\"OrganizationEntities\" , \"PersonEntities\" ,\"TitleEntities\" , \n" + 
				"\"CountryEntities\", \"CityEntities\" , \"DurationEntities\", \"DateEntities\",\n" + 
				"\"MoneyEntities\" ,\"CreatedAt\", ts_rank_cd(t1.\"TSV_FULL\", plainto_tsquery('"+strTopicText+"')) as topicrnk \n" + 
				"FROM (  SELECT \"TopicOgUrl\",  \"TopicOgTitle\" ,\"TopicOgDescription\", \"TopicUrlCount\" ,\n" + 
				"\"TopicOgImage\" ,\"OrganizationEntities\" , \"PersonEntities\" ,\"TitleEntities\" , \n" + 
				"\"CountryEntities\", \"CityEntities\" , \"DurationEntities\", \"DateEntities\",\n" + 
				"\"MoneyEntities\",\"CreatedAt\"::timestamp::date as \"CreatedAt\", \"TSV_FULL\"\n" + 
				"	  FROM \"TopicEntityData\", plainto_tsquery('"+strTopicText+"') AS q\n" + 
				"  WHERE (\"TSV_FULL\" @@ q) \n" + 
				") AS t1 where  \n" + 
				" lower(\"TopicOgTitle\") not like '%coupon%' and lower(\"TopicOgTitle\") not like '%course%'  \n" + 
				" and lower(\"TopicOgTitle\") not like '%certifi%'\n"  ;
		
		String orderByTopicRank = " ORDER BY  ts_rank_cd(t1.\"TSV_FULL\", plainto_tsquery('"+strTopicName+"')) desc limit 500" ;
		String orderByCreatedDate = " ORDER BY  \"CreatedAt\" desc limit 2500  " ;
		
		if(strTopicName.indexOf('$')>=0){
			strFullTextSearch = strFullTextSearch + orderByCreatedDate;
		} else {
			strFullTextSearch = strFullTextSearch + orderByTopicRank ;
		}
		
		log.info(strFullTextSearch );

		List<TopicDataModel> lstTopicDataModel = template.query(strFullTextSearch, new TopicSearchContentDataMapper());

		Set<String> urlSet = new HashSet<>();
		List<TopicDataModel> distinctTopicsbyUrl = lstTopicDataModel.stream().filter(e -> urlSet.add(e.getOgUrl()))
				.collect(Collectors.toList());
		/*
		  List<TopicDataModel> sortedList = distinctTopicsbyUrl.stream()
		            .sorted(Comparator.comparingInt(TopicDataModel::getUrlCount).reversed())
		            .collect(Collectors.toList());
		  sortedList.forEach(System.out::println);
		**/
		Map<String, Object> dataMap = null;

		dataMap = new HashMap<String, Object>();
		dataMap.put("data", distinctTopicsbyUrl);
		return dataMap;
	}

	@Override
	public Map<String, Object> findByTopicbyReportType(String TopicText) {
		String strTopicSearchSQL = "select \"TopicOgTitle\" , \"TopicOgDescription\", \"TopicOgUrl\" ,\"TopicOgImage\" from \"TopicEntityData\" where lower(\"TransformedText\") like '%"
				+ TopicText + "%  or lower(TopicOgUrl) like '%" + TopicText
				+ "%' order by \"TopicUrlCount\" desc limit 500";
		List<TopicDataModel> lstTopicDataModel = template.query(strTopicSearchSQL, new TopicContentDataMapper());
		Map<String, Object> dataMap = null;
		JsonArray topicsDataArray = new JsonArray();
		Gson gson = new Gson();

		for (TopicDataModel topicContenData : lstTopicDataModel) {

			topicsDataArray.add(gson.toJson(topicContenData));
			log.info(gson.toJson(topicContenData));

		}

		dataMap = new HashMap<String, Object>();
		dataMap.put("data", topicsDataArray.toString());
		return dataMap;

	}
	
	
	
	@Override
	public Map<String, Object> findTrendingYouTubeVideos(String TopicText) {
		// TODO Auto-generated method stub
		String strTopicText = "youtube.com/watch";
		String strTopicSearchSQL = "select \"Count\" as TopicUrlCount ,   SUBSTRING ( " + " \"TopicUrl\", "
				+ "		POSITION('v=' IN \"TopicUrl\")+2, 11) as TopicOgUrl " + ",  \"TransformedText\" as TopicOgTitle from "
				+ "\"YouTube_Videos\" where lower(\"TopicUrl\") like '%" + strTopicText + "%' "
				+ " order by \"Count\" desc ";

		if (TopicText != null && TopicText.length() > 0 ) {

			strTopicSearchSQL = "select \"Count\" as TopicUrlCount  , SUBSTRING ( " + "		\"TopicUrl\", "
					+ "		POSITION('v=' IN \"TopicUrl\")+2, 11) as TopicOgUrl " + ",  \"TransformedText\" as "
							+ " TopicOgTitle from "
					+ "\"YouTube_Videos\" where lower(\"TopicUrl\") like '%" + strTopicText
					+ "%' and  lower(\"TransformedText\") like '%" + TopicText.toLowerCase() + "%' "
					+ "    order by \"Count\" desc ";

		}
		
		log.info(strTopicSearchSQL);

		List<TopicVideoDataModel> lstTopicDataModel = template.query(strTopicSearchSQL, new TopicYouTubeDataMapper());

		Set<String> urlSet = new HashSet<>();
		List<TopicVideoDataModel> distinctTopicsbyUrl = lstTopicDataModel.stream().filter(e -> urlSet.add(e.getOgUrl()))
				.collect(Collectors.toList());

		Map<String, Object> dataMap = null;

		dataMap = new HashMap<String, Object>();
		dataMap.put("data", distinctTopicsbyUrl);
		return dataMap;

	}
	
	 
	public Map<String, Object> getTrendingYouTubeVideos(String TopicText) {
		// TODO Auto-generated method stub
		String strTopicText = "youtube.com/watch";
		String strTopicSearchSQL = "select count(\"Id\") as TopicUrlCount ,   SUBSTRING ( " + " \"TopicUrl\", "
				+ "		POSITION('v=' IN \"TopicUrl\")+2, 11) as TopicOgUrl " + ",  \"TransformedText\" as TopicOgTitle from "
				+ "\"YouTube_Videos\" where lower(\"TopicUrl\") like '%" + strTopicText + "%' "
				+ " order by \"Count\" desc ";

		if (TopicText != null && TopicText.length() > 0 ) {

			strTopicSearchSQL = "select  \"Count\" as TopicUrlCount  , SUBSTRING ( " + "		\"TopicUrl\", "
					+ "		POSITION('v=' IN \"TopicUrl\")+2, 11) as TopicOgUrl " + ",  \"TransformedText\" as "
							+ " TopicOgTitle from "
					+ "\"YouTube_Videos\" where lower(\"TopicUrl\") like '%" + strTopicText
					+ "%' or  lower(\"TransformedText\") like '%" + TopicText + "%' "
					+ "   order by \"Count\" desc ";

		}
		
		log.info(strTopicSearchSQL);

		List<TopicVideoDataModel> lstTopicDataModel = template.query(strTopicSearchSQL, new TopicYouTubeDataMapper());

		Set<String> urlSet = new HashSet<>();
		List<TopicVideoDataModel> distinctTopicsbyUrl = lstTopicDataModel.stream().filter(e -> urlSet.add(e.getOgUrl()))
				.collect(Collectors.toList());

		Map<String, Object> dataMap = null;

		dataMap = new HashMap<String, Object>();
		dataMap.put("data", distinctTopicsbyUrl);
		return dataMap;

	}



	@Override
	public String storeSharedTopicEvent(String username, String topicurl , String socialMediaName) {
	
		Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("topicurl", topicurl );
	    paramMap.put("username", username );
	    paramMap.put("createdat",  new Timestamp(new Date().getTime()) );
	    paramMap.put("socialmedianame", socialMediaName );
	    
	    int result = template.update(TOPICS_SHARED_INSERT_QUERY, paramMap); 
	    return Integer.toString(result);
		
	}
	
	
	@Override
	public String addTopicToQueue(String username, String topicurl) {
	
		Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("topicurl", topicurl );
	    paramMap.put("username", username );
	    paramMap.put("createdat",  new Timestamp(new Date().getTime()) );
		
	    int result = template.update(TOPIC_QUEUE_INSERT_QUERY, paramMap); 
	    return Integer.toString(result);
		
	}
	
	@Override
	public String topicRead(String username, String topicurl) {
	
		Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("topicurl", topicurl );
	    paramMap.put("username", username );
	    paramMap.put("createdat",  new Timestamp(new Date().getTime()) );
		
	    int result = template.update(TOPICS_READ_INSERT_QUERY, paramMap); 
	    return Integer.toString(result);
		
	}
	
	@Override
	public String likeTopic(String username, String topicurl,String isLiked) {
	
		Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("topicurl", topicurl );
	    paramMap.put("isliked", isLiked );
	    paramMap.put("username", username );
	    paramMap.put("createdat",  new Timestamp(new Date().getTime()) );
		
	    int result = template.update(TOPIC_ENGAGEMENT_INSERT_QUERY, paramMap); 
	    return Integer.toString(result);
		
	}
	
	
	@Override
	public String unLikeTopic(String username, String topicurl,String isLiked) {
	
		Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("topicurl", topicurl );
	    paramMap.put("isliked", isLiked );
	    paramMap.put("username", username );
	    paramMap.put("createdat",  new Timestamp(new Date().getTime()) );
		
	    int result = template.update(TOPIC_ENGAGEMENT_INSERT_QUERY, paramMap); 
	    return Integer.toString(result);
		
	}



	

}
