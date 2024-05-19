package com.krunch.topicranking.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krunch.topicranking.service.TopicDataContentService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/intelligentreports")
public class TopicRankingAlgoController {

	@Resource
	TopicDataContentService topicDataContentService;
	
	Log log = LogFactory.getLog(getClass());


	@RequestMapping("/pingservice")
	public String pingService() {

		System.out.println("Inside Ping Service 1 ..");
		return "Y";

	}

	@RequestMapping("/topic")
	public String getTopics(String topicname,int timeinterval) {
		log.info("Extracting data for Ranking and generating reports for the topic : " + topicname);
		String topicsData = topicDataContentService.genIntelligentTopicReports(topicname, timeinterval);
		return topicsData;
	}

}
