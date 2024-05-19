package com.learn2rise.extraction.content.model;

public class TopicDataModel {
	
	private  String  articlePublishedTime;
	private  String  ogImage;
	private  String  ogSiteName;
	private  String  ogTitle;
	private  String  ogUrlContent;
	private  String  ogDescription;
	private  String  articlePublisher;
	private  String  articleAuthor;
	private  String  articleModified_time;
	private  String  ogLocale;
	private  String  ogUrl;
	private  String  twitterSite;
	private  String  twitterCreator;
	private  String  generator;
	private  String  description;
	private  String  keywords;
	private  int     urlCount;
	private String transformedText;
	private  String  sourceUrl;
	
	private int topicOutgoingLinksCount;
	private String topicOutGoingLinksSet;
	
	
	public String getSourceUrl() {
		return sourceUrl;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	public int getUrlCount() {
		return urlCount;
	}
	public void setUrlCount(int urlCount) {
		this.urlCount = urlCount;
	}
	public String getTransformedText() {
		return transformedText;
	}
	public void setTransformedText(String transformedText) {
		this.transformedText = transformedText;
	}
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getArticlePublishedTime() {
		return articlePublishedTime;
	}
	public void setArticlePublishedTime(String articlePublishedTime) {
		this.articlePublishedTime = articlePublishedTime;
	}
	public String getOgImage() {
		return ogImage;
	}
	public void setOgImage(String ogImage) {
		this.ogImage = ogImage;
	}
	public String getOgSiteName() {
		return ogSiteName;
	}
	public void setOgSiteName(String ogSiteName) {
		this.ogSiteName = ogSiteName;
	}
	public String getOgTitle() {
		return ogTitle;
	}
	public void setOgTitle(String ogTitle) {
		this.ogTitle = ogTitle;
	}
	public String getOgUrlContent() {
		return ogUrlContent;
	}
	public void setOgUrlContent(String ogUrlContent) {
		this.ogUrlContent = ogUrlContent;
	}
	public String getOgDescription() {
		return ogDescription;
	}
	public void setOgDescription(String ogDescription) {
		this.ogDescription = ogDescription;
	}
	public String getArticlePublisher() {
		return articlePublisher;
	}
	public void setArticlePublisher(String articlePublisher) {
		this.articlePublisher = articlePublisher;
	}
	public String getArticleAuthor() {
		return articleAuthor;
	}
	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}
	public String getArticleModified_time() {
		return articleModified_time;
	}
	public void setArticleModified_time(String articleModified_time) {
		this.articleModified_time = articleModified_time;
	}
	public String getOgLocale() {
		return ogLocale;
	}
	public void setOgLocale(String ogLocale) {
		this.ogLocale = ogLocale;
	}
	public String getOgUrl() {
		return ogUrl;
	}
	public void setOgUrl(String ogUrl) {
		this.ogUrl = ogUrl;
	}
	public String getTwitterSite() {
		return twitterSite;
	}
	public void setTwitterSite(String twitterSite) {
		this.twitterSite = twitterSite;
	}
	public String getTwitterCreator() {
		return twitterCreator;
	}
	public void setTwitterCreator(String twitterCreator) {
		this.twitterCreator = twitterCreator;
	}
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
	public int getTopicOutgoingLinksCount() {
		return topicOutgoingLinksCount;
	}
	public void setTopicOutgoingLinksCount(int topicOutgoingLinksCount) {
		this.topicOutgoingLinksCount = topicOutgoingLinksCount;
	}
	public String getTopicOutGoingLinksSet() {
		return topicOutGoingLinksSet;
	}
	public void setTopicOutGoingLinksSet(String topicOutGoingLinksSet) {
		this.topicOutGoingLinksSet = topicOutGoingLinksSet;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((articleAuthor == null) ? 0 : articleAuthor.hashCode());
		result = prime * result + ((articleModified_time == null) ? 0 : articleModified_time.hashCode());
		result = prime * result + ((articlePublishedTime == null) ? 0 : articlePublishedTime.hashCode());
		result = prime * result + ((articlePublisher == null) ? 0 : articlePublisher.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((generator == null) ? 0 : generator.hashCode());
		result = prime * result + ((keywords == null) ? 0 : keywords.hashCode());
		result = prime * result + ((ogDescription == null) ? 0 : ogDescription.hashCode());
		result = prime * result + ((ogImage == null) ? 0 : ogImage.hashCode());
		result = prime * result + ((ogLocale == null) ? 0 : ogLocale.hashCode());
		result = prime * result + ((ogSiteName == null) ? 0 : ogSiteName.hashCode());
		result = prime * result + ((ogTitle == null) ? 0 : ogTitle.hashCode());
		result = prime * result + ((ogUrl == null) ? 0 : ogUrl.hashCode());
		result = prime * result + ((ogUrlContent == null) ? 0 : ogUrlContent.hashCode());
		result = prime * result + ((transformedText == null) ? 0 : transformedText.hashCode());
		result = prime * result + ((twitterCreator == null) ? 0 : twitterCreator.hashCode());
		result = prime * result + ((twitterSite == null) ? 0 : twitterSite.hashCode());
		result = prime * result + urlCount;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TopicDataModel other = (TopicDataModel) obj;
		if (articleAuthor == null) {
			if (other.articleAuthor != null)
				return false;
		} else if (!articleAuthor.equals(other.articleAuthor))
			return false;
		if (articleModified_time == null) {
			if (other.articleModified_time != null)
				return false;
		} else if (!articleModified_time.equals(other.articleModified_time))
			return false;
		if (articlePublishedTime == null) {
			if (other.articlePublishedTime != null)
				return false;
		} else if (!articlePublishedTime.equals(other.articlePublishedTime))
			return false;
		if (articlePublisher == null) {
			if (other.articlePublisher != null)
				return false;
		} else if (!articlePublisher.equals(other.articlePublisher))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (generator == null) {
			if (other.generator != null)
				return false;
		} else if (!generator.equals(other.generator))
			return false;
		if (keywords == null) {
			if (other.keywords != null)
				return false;
		} else if (!keywords.equals(other.keywords))
			return false;
		if (ogDescription == null) {
			if (other.ogDescription != null)
				return false;
		} else if (!ogDescription.equals(other.ogDescription))
			return false;
		if (ogImage == null) {
			if (other.ogImage != null)
				return false;
		} else if (!ogImage.equals(other.ogImage))
			return false;
		if (ogLocale == null) {
			if (other.ogLocale != null)
				return false;
		} else if (!ogLocale.equals(other.ogLocale))
			return false;
		if (ogSiteName == null) {
			if (other.ogSiteName != null)
				return false;
		} else if (!ogSiteName.equals(other.ogSiteName))
			return false;
		if (ogTitle == null) {
			if (other.ogTitle != null)
				return false;
		} else if (!ogTitle.equals(other.ogTitle))
			return false;
		if (ogUrl == null) {
			if (other.ogUrl != null)
				return false;
		} else if (!ogUrl.equals(other.ogUrl))
			return false;
		if (ogUrlContent == null) {
			if (other.ogUrlContent != null)
				return false;
		} else if (!ogUrlContent.equals(other.ogUrlContent))
			return false;
		if (transformedText == null) {
			if (other.transformedText != null)
				return false;
		} else if (!transformedText.equals(other.transformedText))
			return false;
		if (twitterCreator == null) {
			if (other.twitterCreator != null)
				return false;
		} else if (!twitterCreator.equals(other.twitterCreator))
			return false;
		if (twitterSite == null) {
			if (other.twitterSite != null)
				return false;
		} else if (!twitterSite.equals(other.twitterSite))
			return false;
		if (urlCount != other.urlCount)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TopicDataModel [articlePublishedTime=" + articlePublishedTime + ", ogImage=" + ogImage + ", ogSiteName="
				+ ogSiteName + ", ogTitle=" + ogTitle + ", ogUrlContent=" + ogUrlContent + ", ogDescription="
				+ ogDescription + ", articlePublisher=" + articlePublisher + ", articleAuthor=" + articleAuthor
				+ ", articleModified_time=" + articleModified_time + ", ogLocale=" + ogLocale + ", ogUrl=" + ogUrl
				+ ", twitterSite=" + twitterSite + ", twitterCreator=" + twitterCreator + ", generator=" + generator
				+ ", description=" + description + ", keywords=" + keywords + ", urlCount=" + urlCount
				+ ", transformedText=" + transformedText + "]";
	}
	


	
	

}
