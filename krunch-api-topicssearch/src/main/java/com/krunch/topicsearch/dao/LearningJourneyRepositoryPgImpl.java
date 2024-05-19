package com.krunch.topicsearch.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.krunch.topicsearch.entity.TopicBarChartData;
import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicPieChartData;
import com.krunch.topicsearch.entity.TopicRecommendations;
import com.krunch.topicsearch.mapper.TopicBarChartMapper;
import com.krunch.topicsearch.mapper.TopicPieChartMapper;
import com.krunch.topicsearch.mapper.TopicRecommendationsDataMapper;

@Repository
public class LearningJourneyRepositoryPgImpl implements LearningJourneyRepository {

	public LearningJourneyRepositoryPgImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	NamedParameterJdbcTemplate template;
	
	Log log = LogFactory.getLog(getClass());


	@Override
	public List<TopicPieChartData> getUserPieChartData(String userName) {

		String strPieChartDataSQL = "select tcount,engagementtype from (\n"
				+ "select count(\"Id\") as tcount, 'read' as engagementtype from \"User_Topics_Read\" where \"User_Name\" = '"
				+ userName + "' " + "union\n"
				+ "select count(\"Id\") as tcount , 'shared' as engagementtype from \"User_Topics_Shared\" where \"User_Name\" = '"
				+ userName + "' " + "union\n"
				+ "select count(\"Id\") as tcount, 'userqueue' as engagementtype from \"User_Topic_Queue\" where \"User_Name\" = '"
				+ userName + "' " + "union\n"
				+ "select count(\"Id\") as tcount , 'liked' as engagementtype from \"User_Topic_Engagement\" where \"User_Name\" = '"
				+ userName + "' " + "and \"is_Liked\" = 'Y'\n" + "union \n"
				+ "select count(\"Id\") as tcount, 'unliked' as engagementtype from \"User_Topic_Engagement\" where \"User_Name\" = '"
				+ userName + "' " + "and \"is_Liked\" = 'N') as  t1 order by engagementtype asc";
		List<TopicPieChartData> lstTopicPieChartData = template.query(strPieChartDataSQL, new TopicPieChartMapper());

		return lstTopicPieChartData;

	}

	@Override
	public List<TopicBarChartData> getUserBarChartData(String userName) {

	//	String strBarChartDataSQL = "SELECT To_Char(date,'YYYY-MM-DD') as labels,count as data FROM \"VW_Users_Reading_History\" "
	//			+ "		where date is not null and \"User_Name\" = '" + userName + "' " + " 		order by date desc";
		String strBarChartDataSQL = "SELECT To_Char(date,'YYYY-MM-DD') as labels,count as data FROM \"VW_Users_Reading_History\" "
				+ "		where \"User_Name\" = '" + userName + "' " + " 		order by date desc";
	
		
		List<TopicBarChartData> lstTopicBarChartData = template.query(strBarChartDataSQL, new TopicBarChartMapper());

		return lstTopicBarChartData;

	}

	@Override
	public List<TopicDataModel> getUserTopicQueue(String userName) {
		// TODO Auto-generated method stub

		String strGetTop10UserQueueTopics = "";

		return null;
	}

	@Override
	public List<TopicRecommendations> getUserTopicRecommendations(String topicTitle, int noOfTopics) {
		// TODO Auto-generated method stub

		topicTitle = topicTitle.replaceAll("'", "''");
		String strChildrenNodeTopicDataSQL = "select \"TopicOgTitle\" ,\"TopicOgUrl\" , \"TopicOgDescription\"\n"
				+ "from \"TopicEntityData\"\n" + "where \"TopicOgTitle\"!='" + topicTitle + "'\n"
				+ "order by similarity(\"TopicOgTitle\", '" + topicTitle + "')\n" + "desc limit " + noOfTopics + " ";

		log.info("Query To be Executed : " + strChildrenNodeTopicDataSQL);

		List<TopicRecommendations> lstTopicRecommendations = template.query(strChildrenNodeTopicDataSQL,
				new TopicRecommendationsDataMapper());

		return lstTopicRecommendations;
	}

	@Override
	public List<TopicRecommendations> getUserResearchTopics(String userName) {

		String strResearchTopicDataSQL = "select \"TopicOgTitle\" , \"TopicOgDescription\" , \"TopicOgUrl\" from \"User_Topic_Queue\" utq,\n"
				+ "\"TopicEntityData\" ted where utq.\"User_Name\" = '" + userName + "'\n"
				+ "and utq.\"Topic_Url_Id\" = ted.\"TopicOgUrl\" order by utq.\"CreatedAt\" desc limit 12";

		// log.info("Query To be Executed : "+strResearchTopicDataSQL);
		List<TopicRecommendations> lstResearchTopics = template.query(strResearchTopicDataSQL,
				new TopicRecommendationsDataMapper());
		return lstResearchTopics;
	}

	@Override
	public List<TopicBarChartData> getUserRecentTopicQueueData(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
