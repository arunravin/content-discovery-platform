package com.twitter.producer.service.helper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.stereotype.Component;

import com.twitter.producer.config.TwitterProperties;

@Component
public class FilterTopics {

	private final Logger log = LoggerFactory.getLogger(FilterTopics.class);

	@Autowired
	private final TwitterProperties twitterProperties;

	public FilterTopics(TwitterProperties twitterProperties) {
		this.twitterProperties = twitterProperties;
	}


	public boolean filterTweetTopics(Tweet tweet) {

		boolean filterOutTopic = false;
	   
		 //filter non-English tweets:
        if (!"en".equals(tweet.getLanguageCode())) {
        		filterOutTopic = true;
		}
		
		String[] filterKeyWords = twitterProperties.getFilterKeyWords().split(",");
		for (String filterKeyWord : filterKeyWords) {

			if (tweet.getText().toLowerCase().contains(filterKeyWord)) {
				filterOutTopic = true;
				break;
			}
		}

		if (tweet.getEntities().getUrls() != null && tweet.getEntities().getUrls().get(0).getExpandedUrl().isEmpty())
			filterOutTopic = true;

		return filterOutTopic;
	}

	public boolean filterTweetTopics(String topicText) {

		return false;
	}

}
