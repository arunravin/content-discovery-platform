package com.krunch.topicsearch.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krunch.topicsearch.entity.TopicDataModel;
import com.krunch.topicsearch.entity.TopicRecommendations;
import com.krunch.topicsearch.service.TopicDataContentService;
import com.krunch.topicsearch.vo.UserTopic;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/digitaltrends")
public class KnowledgeAccelarationController {

	@Resource
	TopicDataContentService topicDataContentService;

	Log log = LogFactory.getLog(getClass());

	
	@RequestMapping("/pingService")
	public String pingService() {

		return "Y";

	}
	
	  @PostMapping("/topics/addtoqueue")
	    public String addTopicToQueue( @RequestBody UserTopic userTopic )  {
		  
	    	log.info("UserName : " + userTopic.getUsername() + "TopicUrl: " + userTopic.getTopicurl()) ;
	        return topicDataContentService.addTopicToQueue( userTopic.getUsername(), userTopic.getTopicurl() );
	    }
	  
	  @PostMapping("/topics/sharetopic")
	    public String shareTopicEvent( @RequestBody UserTopic userTopic )  {
		  
	    	log.info("UserName : " + userTopic.getUsername() + "TopicUrl: " + userTopic.getTopicurl() + "" + userTopic.getSocialMediaName())  ;
	        return topicDataContentService.storeSharedTopicEvent( userTopic.getUsername(), userTopic.getTopicurl() ,userTopic.getSocialMediaName());
	    }
	  
	  @PostMapping("/topics/topicread")
	    public String topicRead( @RequestBody UserTopic userTopic )  {
		  
	    	log.info("UserName : " + userTopic.getUsername() + "TopicUrl: " + userTopic.getTopicurl()) ;
	        return topicDataContentService.topicRead( userTopic.getUsername(), userTopic.getTopicurl() );
	    }


	  @PostMapping("/topics/like")
	    public String likeTopic( @RequestBody UserTopic userTopic )  {
		  
	    	log.info("UserName : " + userTopic.getUsername() + "TopicUrl: " + userTopic.getTopicurl()) ;
	        return topicDataContentService.likeTopic( userTopic.getUsername(), userTopic.getTopicurl(),userTopic.getIsliked() );
	    }

	  @PostMapping("/topics/unlike")
	    public String unLikeTopic( @RequestBody UserTopic userTopic )  {
		  
	    	log.info("UserName : " + userTopic.getUsername() + "TopicUrl: " + userTopic.getTopicurl()) ;
	        return topicDataContentService.unLikeTopic( userTopic.getUsername(), userTopic.getTopicurl(),userTopic.getIsliked() );
	    }


	@RequestMapping("/topicsdata")
	public List<TopicDataModel> getTopics(String topic) {
		log.info("Inside getTopics : "+ topic);
		// String TopicText="MICROSERVICE";
		List<TopicDataModel> lstTopicDataModel  = topicDataContentService.findByTopicText(topic);
		//log.info(strTopicsResponseData.toString());
		log.info("getTopics Size : "+lstTopicDataModel.size());
		return lstTopicDataModel;
		
	}
	
	@RequestMapping("/toptrends")
	public List<TopicRecommendations> getTopTrends(String topic) {
		
		log.info("Inside getTopTrends : "+ topic);
		// String TopicText="MICROSERVICE";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap = topicDataContentService.findTrendingTopics(topic);
		List<TopicRecommendations> lstTopTrends  =  (List<TopicRecommendations>) dataMap.get("data");
		//log.info(strTopicsResponseData.toString());
		log.info("getTopics Size : "+lstTopTrends.size());
		return lstTopTrends;
		
	}
	
	@RequestMapping("/videos")
	public List<TopicDataModel> getYouTubeVideos(String topic) {
		log.info("Enter Get YouTube Videos .."+topic);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap = topicDataContentService.findTrendingYouTubeVideos(topic);
		List<TopicDataModel> lstTopicDataModel  =  (List<TopicDataModel>) dataMap.get("data");
		//log.info(strTopicsResponseData.toString());
		log.info("getVideos Size : "+lstTopicDataModel.size());
		return lstTopicDataModel;
		
	}

	@RequestMapping("/topicentitysearch")
	public List<TopicDataModel> getDatabyEntityType(String topic) {
		log.info("Inside Entity Search  ......."+topic);
		// String TopicText="MICROSERVICE";
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap = topicDataContentService.findByTopicbyEntityType(topic);
		List<TopicDataModel> lstTopicDataModel  =  (List<TopicDataModel>) dataMap.get("data");
		//log.info(strTopicsResponseData.toString());
		log.info("getDatabyEntityType Size : "+lstTopicDataModel.size());
		return lstTopicDataModel;

	}

}
