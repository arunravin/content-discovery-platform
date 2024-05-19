package com.krunch.topicranking.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.krunch.topicranking.algo.TopicRankingPipeline;
import com.krunch.topicranking.dao.TopicsDataRepositoryPgImpl;
import com.krunch.topicranking.entity.TopicRankingDataModel;

@Component
public class TopicDataContentServiceImpl implements TopicDataContentService {

	@Resource
	TopicsDataRepositoryPgImpl topicsDataDao;
	
	@Resource
	TopicRankingPipeline topicRankingPipeline;
	
	@Override
	public String genIntelligentTopicReports(String topicName,int timeIntervalfromToday) {
		
		 topicRankingPipeline.initProcessData(topicName,timeIntervalfromToday);
		 topicRankingPipeline.buildPipeLine(topicName);
		 try {
			topicRankingPipeline.executePipelines(topicName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		
		 
		 return "Success - with Result ";
		 
	}

	
}
