package com.krunch.topicsearch.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.krunch.topicsearch.dao.TopicsDataRepositoryPgImpl;
import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.ranking.TACalculateArticleContentDataWeightage;

@Component
public class TopicDataContentServiceImpl implements TopicDataContentService {

	@Resource
	TopicsDataRepositoryPgImpl topicsDataDao;
	
	@Override
	@Cacheable(
			  cacheNames="demoCache",
		      key 		= "#TopicText" )
	public List<TopicDataModel> findByTopicText(String TopicText) {
		System.out.println("Getting from Database .. ");
		
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap = topicsDataDao.findByTopicText(TopicText);
		List<TopicDataModel> lstTopicDataModel  =  (List<TopicDataModel>) dataMap.get("data");
		/*
		TACalculateArticleContentDataWeightage objContentDataWeightage = new TACalculateArticleContentDataWeightage();
		
		for (TopicDataModel  tpm : lstTopicDataModel) { 		      
	        		double dblTopicContentEntitiesScore = objContentDataWeightage.calculateContentWeight(tpm, null);
	        		System.out.println(tpm.getOgUrl() + "  Score : " + dblTopicContentEntitiesScore);
	      }	
	      **/
	
		return lstTopicDataModel;
	}
	
	
	@Override
	@Cacheable(
			  cacheNames="trendsCache",
		      key 		= "#TopicText" )
	public Map<String, Object> findTrendingTopics(String TopicText) {
		System.out.println("Getting from Database .. ");
		return topicsDataDao.findTrendingTopics(TopicText);
	}

	@Override
	public Map<String, Object> findByTopicbyReportType(String TopicText) {
		
		return topicsDataDao.findByTopicbyReportType(TopicText);
	}

	@Override
	public Map<String, Object> findByTopicbyEntityType(String TopicText) {
		// TODO Auto-generated method stub
		return topicsDataDao.findByTopicbyEntityType(TopicText);
	}

	@Override
	public Map<String, Object> findTrendingYouTubeVideos(String TopicText) {
		// TODO Auto-generated method stub
		return topicsDataDao.findTrendingYouTubeVideos(TopicText);
	}
	
	@Override
	public String topicRead(String username, String topicurl) {
		// TODO Auto-generated method stub
		return topicsDataDao.topicRead(username, topicurl);
	}

	@Override
	public String addTopicToQueue(String username, String topicurl) {
		// TODO Auto-generated method stub
		return topicsDataDao.addTopicToQueue(username, topicurl);
	}
	
	@Override
	public String likeTopic(String username, String topicurl,String isliked) {
		// TODO Auto-generated method stub
		return topicsDataDao.likeTopic(username, topicurl,isliked);
	}
	
	@Override
	public String unLikeTopic(String username, String topicurl,String isliked) {
		// TODO Auto-generated method stub
		return topicsDataDao.unLikeTopic(username, topicurl,isliked);
	}

	@Override
	public String storeSharedTopicEvent(String username, String topicurl, String socialMediaName) {
		// TODO Auto-generated method stub
		return topicsDataDao.storeSharedTopicEvent(username, topicurl, socialMediaName);
	}
	
	
	

}
