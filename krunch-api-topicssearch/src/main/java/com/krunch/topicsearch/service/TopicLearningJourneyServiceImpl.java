package com.krunch.topicsearch.service;

import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.krunch.topicsearch.barchart.json.GenerateBarChartJsonData;
import com.krunch.topicsearch.dao.LearningJourneyRepositoryPgImpl;
import com.krunch.topicsearch.entity.TopicBarChartData;
import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicPieChartData;
import com.krunch.topicsearch.entity.TopicRecommendations;
import com.krunch.topicsearch.piechart.json.GenerateChartJsonData;
import com.krunch.topicsearch.recommendations.json.Children;
import com.krunch.topicsearch.recommendations.json.Data;
import com.krunch.topicsearch.recommendations.json.DataContainer;
import com.krunch.topicsearch.recommendations.json.TopNode;

@Component
public class TopicLearningJourneyServiceImpl implements TopicLearningJourneyService {

	@Resource
	LearningJourneyRepositoryPgImpl learningJourneyDataDao;
	
	Log log = LogFactory.getLog(getClass());


	@Override
	public String getUserActivity(String userName) {

		List<TopicBarChartData> lstTopicBarChartData = learningJourneyDataDao.getUserBarChartData(userName);

		int[] data = new int[lstTopicBarChartData.size()];
		String[] labels = new String[lstTopicBarChartData.size()];
		int i = 0;

		for (TopicBarChartData topicContenData : lstTopicBarChartData) {
			data[i] = topicContenData.getData();
			labels[i] = topicContenData.getLabels();
			++i;
		}

		GenerateBarChartJsonData genBarChartData = new GenerateBarChartJsonData();

		genBarChartData.setIntdata(data);
		genBarChartData.setLabels(labels);
		genBarChartData.setBackgroundColor("rgba(89,139,255,0.8)");

		//String pieCharatJsonData = genBarChartData.getBarChartDataJson();

		String trendChartJsonData = genBarChartData.getTrendsDataJson();
		log.info("TrendCharatJsonData" + trendChartJsonData);

		return trendChartJsonData;
	}

	@Override
	public String getUserLearningEngagements(String userName) {

		List<TopicPieChartData> lstTopicPieChartData = learningJourneyDataDao.getUserPieChartData(userName);

		int[] data = new int[50];
		int i = 0;

		for (TopicPieChartData topicContenData : lstTopicPieChartData) {
			data[i] = topicContenData.getTcount();
			++i;
		}

		GenerateChartJsonData genPieChartData = new GenerateChartJsonData();

		genPieChartData.setIntdata(data);
		String pieCharatJsonData = genPieChartData.getPieChartDataJson();

		log.info("CharatJsonData" + pieCharatJsonData);

		return pieCharatJsonData;
	}

	@Override
	public Map<String, Object> getUserAchievements(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserRecommendations(String topicTitle) {
		// TODO Auto-generated method stub
		List<TopicRecommendations> lstTopicRecommendations = learningJourneyDataDao
				.getUserTopicRecommendations(topicTitle, 5);

		List<Children> children = new ArrayList<Children>();

		for (int i = 0; i < lstTopicRecommendations.size(); i++) {

			TopicRecommendations topicRecommendationsData = lstTopicRecommendations.get(i);
			Data data = new Data(topicRecommendationsData.getName(), topicRecommendationsData.getType(),
					topicRecommendationsData.getUrl());
			Children childdata = new Children(data);
			children.add(childdata);

		}

		Gson gson = new Gson();
		String finalJson = gson.toJson(children);

		log.info("Children Node Json" + finalJson);

		return finalJson;

	}

	@Override
	@CacheEvict(cacheNames = "homePageCache", key = "#userName")
	public void clearUserCache(String userName) {
		log.info("clearUserName invoked for id=" + userName);
	}

	@Override
	@Cacheable(cacheNames = "homePageCache", key = "#userName")
	public String getUserResearchTopics(String userName) {
		// TODO Auto-generated method stub

		log.info("Inside Service ..." + userName);

		List<TopicRecommendations> lstResearchTopics = learningJourneyDataDao.getUserResearchTopics(userName);

		Data branchData = null;
		List<DataContainer> dataContainer = new ArrayList<DataContainer>();
		List<Children> children = new ArrayList<Children>();

		for (int i = 0; i < lstResearchTopics.size(); i++) {

			TopicRecommendations topicRecommendationsData = lstResearchTopics.get(i);
			branchData = new Data(topicRecommendationsData.getName(), topicRecommendationsData.getType(),
					topicRecommendationsData.getUrl());

			List<TopicRecommendations> lstTopicRecommendations = learningJourneyDataDao
					.getUserTopicRecommendations(topicRecommendationsData.getName(), 5);
			children = new ArrayList<Children>();
			for (int j = 0; j < lstTopicRecommendations.size(); j++) {

				TopicRecommendations topicChildrenData = lstTopicRecommendations.get(j);
				Data data = new Data(topicChildrenData.getName(), topicChildrenData.getType(),
						topicChildrenData.getUrl());
				Children childDataContainer = new Children(data);
				children.add(childDataContainer);

			}

			dataContainer.add(new DataContainer(branchData, children));

		}

		Gson gson = new Gson();
		String finalJson = gson.toJson(dataContainer);
		log.info(userName + " : User Research Topics response completed .. ");

		return finalJson;

	}

	@Override
	public String getMyTopicsWordCloud(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
