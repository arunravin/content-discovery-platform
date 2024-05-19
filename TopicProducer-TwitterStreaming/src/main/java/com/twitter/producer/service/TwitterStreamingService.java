package com.twitter.producer.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.twitter.api.FilterStreamParameters;
import org.springframework.social.twitter.api.StreamDeleteEvent;
import org.springframework.social.twitter.api.StreamListener;
import org.springframework.social.twitter.api.StreamWarningEvent;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.twitter.producer.config.KafkaProducer;
import com.twitter.producer.config.KafkaProperties;
import com.twitter.producer.config.TwitterProperties;
import com.twitter.producer.mapper.json.MapTopictoJson;
import com.twitter.producer.model.TopicVO;
import com.twitter.producer.service.helper.FilterTopics; 

@Service
public class TwitterStreamingService {

    private final Logger log = LoggerFactory.getLogger(TwitterStreamingService.class);

    private final Twitter twitter;

    private final KafkaProperties kafkaProperties;
    
    private final TwitterProperties twitterProperties;

    private final KafkaProducer kafkaProducerService;
    
    private final MapTopictoJson mapTopictoJson;
        
    private final FilterTopics filterTopics;
    
   
    
    public TwitterStreamingService(Twitter twitter, KafkaProperties kafkaProperties, 
    		KafkaProducer kafkaProducerService,TwitterProperties twitterProperties, 
    		FilterTopics filterTopics , MapTopictoJson mapTopictoJson
    		) {
    	
        this.twitter = twitter;
        this.kafkaProperties = kafkaProperties;
        this.kafkaProducerService = kafkaProducerService;
        this.twitterProperties=twitterProperties;
        this.filterTopics=filterTopics;    
        this.mapTopictoJson = mapTopictoJson;
        
    }

    public void stream() {
        List<StreamListener> listeners = new ArrayList<>();
        
        StreamListener streamListener = new StreamListener() {
            @Override
            public void onTweet(Tweet tweet) {
              int counter = 0;
                 
                 //  1).Insert Json Data Type in PostgreSql [ID , Date , Json Data]
                 // 2).Adhoc Daily Report , Deduplication Process
                 // 3).Results Extraction - PDF/Excel , Database Insertion , API Specific Output 
            	// 4).Angular SPA displaying Realtime Tweets
     
            	
               if(filterTopics.filterTweetTopics(tweet))  return;
               
               TopicVO topicVO = mapTopictoJson.convertTopicObjecttoVO(tweet);  
               
              // Gson gson = new Gson();
               Gson gson = new Gson();
               String topicJson = gson.toJson(topicVO);
              // log.info("Printing Topic Json " + topicJson );
               
               System.out.println("------------------------------------");
               System.out.println(topicVO.getTransformedText());
               System.out.println(topicVO.getTopicUrl());
               System.out.println(topicVO.getSharedCount() + "::" + topicVO.getLikedCount() + " :: " + topicVO.getLocation());
               System.out.println("------------------------------------");
               counter++;
               if(counter == kafkaProperties.getBatchSize()){
                kafkaProducerService.send(kafkaProperties.getTemplate().getDefaultTopic(), 
                String.valueOf(topicVO.getId()),topicJson);
               }
             
            }


            @Override
            public void onDelete(StreamDeleteEvent streamDeleteEvent) {

            }

            @Override
            public void onLimit(int i) {

            }

            @Override
            public void onWarning(StreamWarningEvent streamWarningEvent) {

            }
        };
        //Start Stream when run a service
        listeners.add(streamListener);
        String trackKeyWords = twitterProperties.getTrackTopics();
      //  System.out.println("**************" + trackKeyWords);
        twitter.streamingOperations().filter((FilterStreamParameters) new FilterStreamParameters().track(trackKeyWords), listeners);
       // twitter.streamingOperations().sample(listeners);
    }
}
