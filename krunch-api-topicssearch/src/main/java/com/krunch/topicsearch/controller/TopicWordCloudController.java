package com.krunch.topicsearch.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krunch.topicsearch.entity.CloudData;
import com.krunch.topicsearch.service.TopicWordCloudService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/topics")
public class TopicWordCloudController {

	@Resource
	TopicWordCloudService topicWordCLoudService;
	
	Log log = LogFactory.getLog(getClass());


	@RequestMapping("/pingService")
	public String pingService() {

		// TopicText="Angular";

		return "Y";

	}

	@RequestMapping("/wordcloud")
	public List<CloudData> getMyTopicsWordCloud(String topicName) {

		log.info("Enter Get World Cloud .." + topicName);

		List<CloudData> lstWordCLoudData = topicWordCLoudService.getTopicsWordCloud(topicName);

		return lstWordCLoudData;

	}

	@RequestMapping("/wordcloud/person")
	public List<CloudData> getPersonTopicsWordCloud(String topicName) {

		log.info("Enter Get World Cloud .." + topicName);

		List<CloudData> lstWordCLoudData = topicWordCLoudService.getPersonTopicsWordCloud(topicName);

		log.info("Response for World Cloud .." + lstWordCLoudData.size());

		return lstWordCLoudData;

	}

	@RequestMapping("/wordcloud/keyword")
	public List<CloudData> getTopicNameWordCloud(String topicName) {

		log.info("Enter Get World Cloud for Keyword.." + topicName);

		List<CloudData> lstWordCLoudData = topicWordCLoudService.getTopicNameWordCloud(topicName);

		log.info("Response for World Cloud .." + lstWordCLoudData.size());

		return lstWordCLoudData;

	}
	
	
	@RequestMapping("/wordcloud/keyword/person")
	public List<CloudData> getPersonWordCloud(String topicName) {

		log.info("Enter Get World Cloud for Keyword.." + topicName);

		List<CloudData> lstWordCLoudData = topicWordCLoudService.getPersonWordCloud(topicName);

		log.info("Response for World Cloud .." + lstWordCLoudData.size());

		return lstWordCLoudData;

	}

}
