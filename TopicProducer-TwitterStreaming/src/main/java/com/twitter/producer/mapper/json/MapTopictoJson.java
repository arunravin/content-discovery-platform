package com.twitter.producer.mapper.json;

import java.sql.Timestamp;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.twitter.producer.model.TopicVO;
import com.twitter.producer.service.helper.TwitterStringsUtils;

@Component
public class MapTopictoJson {
	
	private final Logger log = LoggerFactory.getLogger(MapTopictoJson.class);
	
	@Autowired
	private  TopicVO topicVO;
	
	
	public MapTopictoJson( TopicVO topicVO) {
	        this.topicVO = topicVO;
	    }
	
	
	 public TopicVO convertTopicObjecttoVO(Tweet topic ) {
	     
        String tweetText = topic.getText();
        
        TwitterStringsUtils tweetUtils = new TwitterStringsUtils(true,true,true);
        
        String topicURL = tweetUtils.getTopicExpandedURL(topic);
        String hashTagsCombined = tweetUtils.getTopicTags(topic);
        String transformedText =tweetUtils.transformTopic(tweetText);
		
		/*
		 * log.info("1).Topic URL :" +topicURL); log.info("2).Hash Tags :"
		 * +hashTagsCombined); log.info("3).Original Tweet Text :" +topic.getText());
		 * log.info("4).Transformed Tweet Text :" +transformedText);
		 * 
		 */	
        Date date=new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        
        
       // System.out.println("*******************************************"+timestamp+"***************");
        topicVO.setOriginalText(tweetText);
		//topicVO.setCreatedAt(timestamp);
		topicVO.setFavoriteCount(topic.getFavoriteCount().intValue());
		topicVO.setFollowersCount(topic.getUser().getFollowersCount());
		topicVO.setFollowingCount(topic.getUser().getFriendsCount());
		topicVO.setId(topic.getId());
		topicVO.setLikedCount(topic.getRetweetedStatus().getFavoriteCount());
		topicVO.setLocation(topic.getUser().getLocation());
		topicVO.setOriginalText(topic.getText());
		topicVO.setRetweetCount(topic.getRetweetCount().intValue());
		topicVO.setSharedCount(topic.getRetweetedStatus().getRetweetCount());
		topicVO.setTopicTags(hashTagsCombined);
		topicVO.setTopicUrl(topicURL);
		topicVO.setTransformedText(transformedText);
		
		
		return topicVO;
	}
	 
	
}
