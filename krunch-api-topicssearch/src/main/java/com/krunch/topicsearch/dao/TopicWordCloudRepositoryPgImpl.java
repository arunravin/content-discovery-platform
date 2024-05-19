package com.krunch.topicsearch.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.krunch.topicsearch.entity.CloudData;
import com.krunch.topicsearch.mapper.TopicWordCloudDataMapper;
import com.krunch.topicsearch.mapper.TopicWordCloudMapper;

@Repository
public class TopicWordCloudRepositoryPgImpl implements TopicWordCloudRepository {

	public TopicWordCloudRepositoryPgImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	Log log = LogFactory.getLog(getClass());

	NamedParameterJdbcTemplate template;

	@Override
	public List<CloudData> getTopicWordCloudData(String topicName) {

		String strTopicWordCloudSQL = "select \"EntityName\" , \"Count\" from \"Topic_Word_Cloud\" "
				+ " where lower(\"TopicName\") = '" + topicName + "' and  "
				+ " lower(\"EntityType\") = 'org' order by \"Count\" desc limit 100";

		log.info(strTopicWordCloudSQL);

		List<CloudData> lstTopicWordCloudData = template.query(strTopicWordCloudSQL, new TopicWordCloudMapper());

		return lstTopicWordCloudData;

	}

	@Override // NotUsed
	public List<CloudData> getPersonTopicWordCloudData(String topicName) {

		String strTopicWordCloudSQL = "select \"EntityName\" , \"Count\" from \"Topic_Word_Cloud\" "
				+ " where lower(\"TopicName\") = '" + topicName + "' and  "
				+ " lower(\"EntityType\") = 'person' order by \"Count\" desc limit 100";

		log.info(strTopicWordCloudSQL);

		
		List<CloudData> lstTopicWordCloudData = template.query(strTopicWordCloudSQL, new TopicWordCloudMapper());

		return lstTopicWordCloudData;

	}

	@Override // Not Used
	public List<String> getTopicNameWordCloudData(String topicName) {
		
		String strTopicWordCloudSQL = "select \"TopicOgTitle\",\"CreatedAt\" ,\"OrganizationEntities\" as \"EntityName\" ,topicrnk from \n"
				+ "(SELECT \"TopicOgTitle\",\"CreatedAt\" ,\"OrganizationEntities\" , \n"
				+ " ts_rank_cd(t1.\"TSV_FULL\", plainto_tsquery('" + topicName + "')) as topicrnk\n"
				+ "FROM (  SELECT \"TopicOgTitle\",\"CreatedAt\" ,\"OrganizationEntities\" , \"TSV_FULL\"\n"
				+ "          FROM \"TopicEntityData\", plainto_tsquery('" + topicName + "') AS q\n"
				+ "  WHERE (\"TSV_FULL\" @@ q)\n" + ") AS t1 where  \n"
				+ " lower(\"TopicOgTitle\") not like '%coupon%' and lower(\"TopicOgTitle\") not like '%course%'\n"
				+ " and lower(\"TopicOgTitle\") not like '%certifi%' \n"
				+ "  ) as t2  where  length(\"OrganizationEntities\") > 3 and  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '1 months' " 
				+ " order by topicrnk desc limit 75";

		log.info(strTopicWordCloudSQL);
		List<String> lstTopicWordCloudData = template.query(strTopicWordCloudSQL, new TopicWordCloudDataMapper());
		return lstTopicWordCloudData;

	}

	
	@Override
	public List<String> getTopicPersonWordCloudData(String topicName) {

		String strTopicWordCloudSQL = "select \"TopicOgTitle\", \"CreatedAt\",\"PersonEntities\" as \"EntityName\" ,topicrnk from \n"
				+ "(SELECT \"TopicOgTitle\",\"PersonEntities\" ,\"CreatedAt\", \n" + " ts_rank_cd(t1.\"TSV_FULL\", plainto_tsquery('"
				+ topicName + "')) as topicrnk\n"
				+ "FROM (  SELECT \"TopicOgTitle\", \"CreatedAt\",\"PersonEntities\" , \"TSV_FULL\"\n"
				+ "          FROM \"TopicEntityData\", plainto_tsquery('" + topicName + "') AS q\n"
				+ "  WHERE (\"TSV_FULL\" @@ q)\n" + ") AS t1 where  \n"
				+ " lower(\"TopicOgTitle\") not like '%coupon%' and lower(\"TopicOgTitle\") not like '%course%'\n"
				+ " and lower(\"TopicOgTitle\") not like '%certifi%' \n"
				+ "  ) as t2  where  length(\"PersonEntities\") > 3 and  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '2 months'"
				+ " order by topicrnk desc limit 75";

		log.info(strTopicWordCloudSQL);

		List<String> lstTopicWordCloudData = template.query(strTopicWordCloudSQL, new TopicWordCloudDataMapper());
 
		return lstTopicWordCloudData;

	}

}
