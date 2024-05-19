package com.krunch.topicsearch.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krunch.topicsearch.service.TopicLearningJourneyService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/learningjourney")
public class KALearningJourneyController {

	@Resource
	TopicLearningJourneyService topicLearningJourneyService;

	Log log = LogFactory.getLog(getClass());

	@RequestMapping("/pingService")
	public String pingService() {

		return "Y";

	}

	@RequestMapping("/engagements1")
	public String getMyLearningEngagements(String userName) {
		log.info("Get Learning Engagements .." + userName);

		String dataMap = topicLearningJourneyService.getUserLearningEngagements(userName);
		return dataMap;

	}

	@RequestMapping("/recommendations")
	public String getMyRecommendedTopics(String topicTitle) {

		log.info("Enter getMyRecommendedTopics .." + topicTitle);
		String topicRecommendations = topicLearningJourneyService.getUserRecommendations(topicTitle);
		return topicRecommendations;

	}

	@RequestMapping("/research")
	public String getUserResearchTopics(String userName) {

		log.info("Enter getUserResearchTopics .." + userName);

		String researchTopics;

		if (userName != null && userName.startsWith("$")) {
			System.out.println("Inside Refresh Topics");
			userName = userName.substring(userName.indexOf("$") + 1, userName.length());
			topicLearningJourneyService.clearUserCache(userName);

			researchTopics = topicLearningJourneyService.getUserResearchTopics(userName);
		} else {
			researchTopics = topicLearningJourneyService.getUserResearchTopics(userName);
		}

		log.info("After Check " + userName);

		return researchTopics;

	}

	@RequestMapping("/wordcloud")
	public String getMyTopicsWordCloud(String userName) {
		log.info("Enter Get Learning Engagements .." + userName);

		String dataMap = topicLearningJourneyService.getUserLearningEngagements(userName);
		return dataMap;

	}

	@RequestMapping("/useractivity")
	public String getUserActivity(String userName) {
		log.info("Enter Get User Activity .." + userName);

		String dataMap = topicLearningJourneyService.getUserActivity(userName);
		return dataMap;

	}

}
