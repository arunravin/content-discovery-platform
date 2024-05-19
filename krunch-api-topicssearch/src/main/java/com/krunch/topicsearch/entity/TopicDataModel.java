package com.krunch.topicsearch.entity;

import java.util.Date;

public class TopicDataModel {
	
	//private  String  articlePublishedTime;
	private  String  ogImage;
	//private  String  ogSiteName;
	private  String  ogTitle;
	//private  String  ogUrlContent;
	private  String  ogDescription;
	//private  String  articlePublisher;
	//private  String  articleAuthor;
	//private  String  articleModified_time;
	//private  String  ogLocale;
	private  String  ogUrl;
	//private  String  twitterSite;
	//private  String  twitterCreator;
	//private  String  generator;
	//private  String  description;
	//private  String  keywords;
	//private  int     urlCount;
	private  int     popularity;
	private  double  relevancy;
	//private String   transformedText;
	
	private String entities;
	
	
	//private String organizationEntities;
	//private String personEntities;
	//private String titleEntities;
	//private String dateEntities;
	//private String durationEntities;
	//private String moneyEntities;
	//private String countryEntities;
	//private String cityEntities;
	private Date   createdAt;
	private String timeInterval;
	private String trendingStatus;
	private int rating;
	private long recency;
	
	public long getRecency() {
		return recency;
	}

	public void setRecency(long recency) {
		this.recency = recency;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getTimeInterval() {
		return timeInterval;
	}

	public void setTimeInterval(String timeInterval) {
		this.timeInterval = timeInterval;
	}

	public String getTrendingStatus() {
		return trendingStatus;
	}

	public void setTrendingStatus(String trendingStatus) {
		this.trendingStatus = trendingStatus;
	}

	
	
	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	/*
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
	
	
	public String getTransformedText() {
		return transformedText;
	}
	public void setTransformedText(String transformedText) {
		this.transformedText = transformedText;
	}
	
		public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getKeywords() {
		return keywords;
	}
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	**/
	
	public String getOgImage() {
		return ogImage;
	}
	public void setOgImage(String ogImage) {
		this.ogImage = ogImage;
	}
	
	public String getOgTitle() {
		return ogTitle;
	}
	public void setOgTitle(String ogTitle) {
		this.ogTitle = ogTitle;
	}
	public String getOgDescription() {
		return ogDescription;
	}
	public void setOgDescription(String ogDescription) {
		this.ogDescription = ogDescription;
	}
	public String getOgUrl() {
		return ogUrl;
	}
	public void setOgUrl(String ogUrl) {
		this.ogUrl = ogUrl;
	}
	public int getPopularity() {
		return popularity;
	}
	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}
	public double getRelevancy() {
		return relevancy;
	}
	public void setRelevancy(double relevancy) {
		this.relevancy = relevancy;
	}
	
	public String getEntities() {
		return entities;
	}

	public void setEntities(String entities) {
		this.entities = entities;
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
		TopicDataModel other = (TopicDataModel) obj;
		
		if (ogUrl == null) {
			if (other.ogUrl != null)
				return false;
		} else if (!ogUrl.equals(other.ogUrl))
			return false;
		
		return true;
	}
	@Override
	public String toString() {
		return "TopicDataModel [ogImage=" + ogImage + ", ogTitle=" + ogTitle + ", ogDescription=" + ogDescription
				+ ", ogUrl=" + ogUrl + ", keywords=" +   ", popularity=" + popularity + ", relevancy="
				+ relevancy + ", createdAt=" + createdAt + ", timeInterval=" + timeInterval + ", trendingStatus="
				+ trendingStatus + "]";
	}
	
	
	
	


	
	

}
