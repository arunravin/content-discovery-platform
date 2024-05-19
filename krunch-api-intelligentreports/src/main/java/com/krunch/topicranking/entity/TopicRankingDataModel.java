package com.krunch.topicranking.entity;

public class TopicRankingDataModel {
	
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
	private String   transformedText;
	
	private String organizationEntities;
	private String personEntities;
	private String titleEntities;
	private String dateEntities;
	private String durationEntities;
	private String moneyEntities;
	private String countryEntities;
	private String cityEntities;
	
	private String topicSourceUrl;
	private int    topicOutGoingLinksCount;	
	private String topicOutGoingLinksUrlSet;

	private double articleOutBoundLinkScore;
	private double contentEntitiesScore;
	private double topicPopularityScore;
	private double topicUserReachability;
	private double documentRelevancy;

	private double contentNLPSummaryScore;
	private double finalScore;
	private String topicClassification;
	private String csvFileName;
	

	private String pipelineStatus;
	
	private double contentWeightScore;
	
	public double getContentWeightScore() {
		return contentWeightScore;
	}
	public void setContentWeightScore(double contentWeightScore) {
		this.contentWeightScore = contentWeightScore;
	}	
	
	public double getArticleMetaDataScore() {
		return contentWeightScore;
	}
	public void setArticleMetaDataScore(double articleMetaDataScore) {
		this.contentWeightScore = articleMetaDataScore;
	}
	public double getArticleOutBoundLinkScore() {
		return articleOutBoundLinkScore;
	}
	public void setArticleOutBoundLinkScore(double articleOutBoundLinkScore) {
		this.articleOutBoundLinkScore = articleOutBoundLinkScore;
	}
	public double getContentEntitiesScore() {
		return contentEntitiesScore;
	}
	public void setContentEntitiesScore(double contentEntitiesScore) {
		this.contentEntitiesScore = contentEntitiesScore;
	}
	public double getTopicPopularityScore() {
		return topicPopularityScore;
	}
	public void setTopicPopularityScore(double topicPopularityScore) {
		this.topicPopularityScore = topicPopularityScore;
	}
	public double getTopicUserReachability() {
		return topicUserReachability;
	}
	public void setTopicUserReachability(double topicUserReachability) {
		this.topicUserReachability = topicUserReachability;
	}
	public double getContentNLPSummaryScore() {
		return contentNLPSummaryScore;
	}
	public void setContentNLPSummaryScore(double contentNLPSummaryScore) {
		this.contentNLPSummaryScore = contentNLPSummaryScore;
	}
	public double getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(double finalScore) {
		this.finalScore = finalScore;
	}
	public String getTopicClassification() {
		return topicClassification;
	}
	public void setTopicClassification(String topicClassification) {
		this.topicClassification = topicClassification;
	}
	public String getPipelineStatus() {
		return pipelineStatus;
	}
	public void setPipelineStatus(String pipelineStatus) {
		this.pipelineStatus = pipelineStatus;
	}
	public int getTopicOutGoingLinksCount() {
		return topicOutGoingLinksCount;
	}
	public void setTopicOutGoingLinksCount(int topicOutGoingLinksCount) {
		this.topicOutGoingLinksCount = topicOutGoingLinksCount;
	}
	public String getTopicOutGoingLinksUrlSet() {
		return topicOutGoingLinksUrlSet;
	}
	public void setTopicOutGoingLinksUrlSet(String topicOutGoingLinksUrlSet) {
		this.topicOutGoingLinksUrlSet = topicOutGoingLinksUrlSet;
	}
	
	public double getDocumentRelevancy() {
		return documentRelevancy;
	}
	public void setDocumentRelevancy(double documentRelevancy) {
		this.documentRelevancy = documentRelevancy;
	}

	public String getTopicSourceUrl() {
		return topicSourceUrl;
	}
	public void setTopicSourceUrl(String topicSourceUrl) {
		this.topicSourceUrl = topicSourceUrl;
	}
	
	public String getOrganizationEntities() {
		return organizationEntities;
	}
	public void setOrganizationEntities(String organizationEntities) {
		this.organizationEntities = organizationEntities;
	}
	public String getPersonEntities() {
		return personEntities;
	}
	public void setPersonEntities(String personEntities) {
		this.personEntities = personEntities;
	}
	public String getTitleEntities() {
		return titleEntities;
	}
	public void setTitleEntities(String titleEntities) {
		this.titleEntities = titleEntities;
	}
	public String getDateEntities() {
		return dateEntities;
	}
	public void setDateEntities(String dateEntities) {
		this.dateEntities = dateEntities;
	}
	public String getDurationEntities() {
		return durationEntities;
	}
	public void setDurationEntities(String durationEntities) {
		this.durationEntities = durationEntities;
	}
	public String getMoneyEntities() {
		return moneyEntities;
	}
	public void setMoneyEntities(String moneyEntities) {
		this.moneyEntities = moneyEntities;
	}
	public String getCountryEntities() {
		return countryEntities;
	}
	public void setCountryEntities(String countryEntities) {
		this.countryEntities = countryEntities;
	}
	public String getCityEntities() {
		return cityEntities;
	}
	public void setCityEntities(String cityEntities) {
		this.cityEntities = cityEntities;
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
	public String getCsvFileName() {
		return csvFileName;
	}
	public void setCsvFileName(String csvFileName) {
		this.csvFileName = csvFileName;
	}
	
	public String getGenerator() {
		return generator;
	}
	public void setGenerator(String generator) {
		this.generator = generator;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ogUrl == null) ? 0 : ogUrl.hashCode());
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
		TopicRankingDataModel other = (TopicRankingDataModel) obj;
		
		if (ogUrl == null) {
			if (other.ogUrl != null)
				return false;
		} else if (!ogUrl.equals(other.ogUrl))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "TopicRankingDataModel [articlePublishedTime=" + articlePublishedTime + ", ogImage=" + ogImage
				+ ", ogSiteName=" + ogSiteName + ", ogTitle=" + ogTitle + ", ogUrlContent=" + ogUrlContent
				+ ", ogDescription=" + ogDescription + ", articlePublisher=" + articlePublisher + ", articleAuthor="
				+ articleAuthor + ", articleModified_time=" + articleModified_time + ", ogLocale=" + ogLocale
				+ ", ogUrl=" + ogUrl + ", twitterSite=" + twitterSite + ", twitterCreator=" + twitterCreator
				+ ", generator=" + generator + ", description=" + description + ", keywords=" + keywords + ", urlCount="
				+ urlCount + ", transformedText=" + transformedText + ", organizationEntities=" + organizationEntities
				+ ", personEntities=" + personEntities + ", titleEntities=" + titleEntities + ", dateEntities="
				+ dateEntities + ", durationEntities=" + durationEntities + ", moneyEntities=" + moneyEntities
				+ ", countryEntities=" + countryEntities + ", cityEntities=" + cityEntities + ", topicSourceUrl="
				+ topicSourceUrl + ", topicOutGoingLinksCount=" + topicOutGoingLinksCount
				+ ", topicOutGoingLinksUrlSet=" + topicOutGoingLinksUrlSet + ", articleMetaDataScore="
				+ contentWeightScore + ", articleOutBoundLinkScore=" + articleOutBoundLinkScore
				+ ", contentEntitiesScore=" + contentEntitiesScore + ", topicPopularityScore=" + topicPopularityScore
				+ ", topicUserReachability=" + topicUserReachability + ", contentNLPSummaryScore="
				+ contentNLPSummaryScore + ", finalScore=" + finalScore + ", topicClassification=" + topicClassification
				+ ", pipelineStatus=" + pipelineStatus + "]";
	}
	
	

	


	
	

}
