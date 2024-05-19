package com.krunch.topicsearch.vo;

public class UserTopic {
	
	private  String  username;
	private  String  topicurl;
	private  String  isliked;
	private  String  socialMediaName;
	
	
	public UserTopic() {
		
		// TODO Auto-generated constructor stub
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTopicurl() {
		return topicurl;
	}
	public void setTopicurl(String topicurl) {
		this.topicurl = topicurl;
	}
	public String getIsliked() {
		return isliked;
	}
	public void setIsliked(String isliked) {
		this.isliked = isliked;
	}
	
	public String getSocialMediaName() {
		return socialMediaName;
	}
	public void setSocialMediaName(String socialMediaName) {
		this.socialMediaName = socialMediaName;
	}
}
