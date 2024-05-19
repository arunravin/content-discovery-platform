package com.learn2rise.extraction.mapping;

import java.util.Map;

import com.learn2rise.extraction.content.model.TopicDataKeyConstants;
import com.learn2rise.extraction.content.model.TopicDataModel;

public class MapTopicDatatoModel {

	public TopicDataModel convertTopicDatatoModel(Map<String, String> hmTopicData,int count, String transformedText, String sourceUrl) {

		TopicDataModel topicModel = new TopicDataModel();
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.ARTICLE_AUTHOR_KEY)) {
			topicModel.setArticleAuthor(hmTopicData.get(TopicDataKeyConstants.ARTICLE_AUTHOR_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.ARTICLE_MODIFIED_TIME_KEY)) {
			topicModel.setArticleModified_time(hmTopicData.get(TopicDataKeyConstants.ARTICLE_MODIFIED_TIME_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.ARTICLE_PUBLISHED_TIME_KEY)) {
			topicModel.setArticlePublishedTime(hmTopicData.get(TopicDataKeyConstants.ARTICLE_PUBLISHED_TIME_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.ARTICLE_PUBLISHER_KEY)) {
			topicModel.setArticlePublisher(hmTopicData.get(TopicDataKeyConstants.ARTICLE_PUBLISHER_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.DESCRIPTION_KEY)) {
			topicModel.setDescription(hmTopicData.get(TopicDataKeyConstants.DESCRIPTION_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.GENERATOR_KEY)) {
			topicModel.setGenerator(hmTopicData.get(TopicDataKeyConstants.GENERATOR_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.OG_IMAGE_KEY)) {
			topicModel.setOgImage(hmTopicData.get(TopicDataKeyConstants.OG_IMAGE_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.OG_DESCRIPTION_KEY)) {
			topicModel.setOgDescription(hmTopicData.get(TopicDataKeyConstants.OG_DESCRIPTION_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.OG_LOCALE_KEY)) {
			topicModel.setOgLocale(hmTopicData.get(TopicDataKeyConstants.OG_LOCALE_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.OG_SITE_NAME_KEY)) {
			topicModel.setOgSiteName(hmTopicData.get(TopicDataKeyConstants.OG_SITE_NAME_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.OG_URL_CONTENT_KEY)) {
			topicModel.setOgUrlContent(hmTopicData.get(TopicDataKeyConstants.OG_URL_CONTENT_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.OG_URL_KEY)) {
			topicModel.setOgUrl(hmTopicData.get(TopicDataKeyConstants.OG_URL_KEY));
		}
		
		if (topicModel.getOgUrl()!=null) {
			
			topicModel.setTopicOutGoingLinksSet(hmTopicData.get(TopicDataKeyConstants.OUTGOING_LINKS_URLS_SET));
			topicModel.setTopicOutgoingLinksCount(Integer.parseInt(hmTopicData.get(TopicDataKeyConstants.OUTGOING_LINKS_COUNT)));
			
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.OG_SITE_NAME_KEY)) {
			topicModel.setOgSiteName(hmTopicData.get(TopicDataKeyConstants.OG_SITE_NAME_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.OG_TITLE_KEY)) {
			topicModel.setOgTitle(hmTopicData.get(TopicDataKeyConstants.OG_TITLE_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.TWITTER_CREATOR_KEY)) {
			topicModel.setTwitterCreator(hmTopicData.get(TopicDataKeyConstants.TWITTER_CREATOR_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.TWITTER_SITE_KEY)) {
			topicModel.setTwitterSite(hmTopicData.get(TopicDataKeyConstants.TWITTER_SITE_KEY));
		}
		
		if(hmTopicData.containsKey(TopicDataKeyConstants.KEYWORDS_KEY)) {
			topicModel.setKeywords(hmTopicData.get(TopicDataKeyConstants.KEYWORDS_KEY));
		}
		
		topicModel.setUrlCount(count);
		topicModel.setTransformedText(transformedText);
		topicModel.setSourceUrl(sourceUrl);
		
		return topicModel;
	}
	
	

}
