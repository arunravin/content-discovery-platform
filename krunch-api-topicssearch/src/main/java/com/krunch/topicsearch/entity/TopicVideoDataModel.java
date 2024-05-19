package com.krunch.topicsearch.entity;

public class TopicVideoDataModel {
	
	private  String  ogTitle;
	private  String  ogUrl;
	private  int     urlCount;
		
	
	public String getOgTitle() {
		return ogTitle;
	}
	public void setOgTitle(String ogTitle) {
		this.ogTitle = ogTitle;
	}
	public String getOgUrl() {
		return ogUrl;
	}
	public void setOgUrl(String ogUrl) {
		this.ogUrl = ogUrl;
	}
	public int getUrlCount() {
		return urlCount;
	}
	public void setUrlCount(int urlCount) {
		this.urlCount = urlCount;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ogTitle == null) ? 0 : ogTitle.hashCode());
		result = prime * result + ((ogUrl == null) ? 0 : ogUrl.hashCode());
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
		TopicVideoDataModel other = (TopicVideoDataModel) obj;
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
		if (urlCount != other.urlCount)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TopicVideoDataModel [ogTitle=" + ogTitle + ", ogUrl=" + ogUrl + ", urlCount=" + urlCount + "]";
	}
		
	
	

	
	

}
