package com.learn2rise.extraction.content.model;

public class TopicDataKeyConstants {
		
	public static final String ARTICLE_PUBLISHED_TIME_KEY = "article:published_time";
	public static final String OG_IMAGE_KEY = "og:image";
	public static final String OG_SITE_NAME_KEY = "og:site_name";
	public static final String OG_TITLE_KEY = "og:title";
	public static final String OG_URL_CONTENT_KEY = "og:urlcontent";
	public static final String OG_DESCRIPTION_KEY = "og:description";
	public static final String ARTICLE_PUBLISHER_KEY = "article:publisher";
	public static final String ARTICLE_AUTHOR_KEY = "article:author";
	public static final String ARTICLE_MODIFIED_TIME_KEY = "article:modified_time";
	public static final String OG_LOCALE_KEY = "og:locale";
	public static final String OG_URL_KEY = "og:url";
	public static final String TWITTER_SITE_KEY = "twitter:site";
	public static final String TWITTER_IMAGE_KEY = "twitter:image";
	public static final String TWITTER_CREATOR_KEY = "twitter:creator";
	public static final String GENERATOR_KEY = "generator";
	public static final String DESCRIPTION_KEY = "og:description";
	public static final String KEYWORDS_KEY="keywords";
	public static final String OUTGOING_LINKS_COUNT ="outgoinglinkscount";
	public static final String OUTGOING_LINKS_URLS_SET="outgoinglinksset";
	
	private TopicDataKeyConstants(){
	    //this prevents even the native class from calling this Actor as well :
	    throw new AssertionError();
	  }

}
