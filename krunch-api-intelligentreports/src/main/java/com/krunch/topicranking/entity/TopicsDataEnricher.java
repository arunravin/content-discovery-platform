package com.krunch.topicranking.entity;

public class TopicsDataEnricher {
	
	private String topicUrl ;
	private int sharedCount;
	private int likedCount;
	private int followersCount;
	private int followingCount;
	
	public String getTopicUrl() {
		return topicUrl;
	}
	public void setTopicUrl(String topicUrl) {
		this.topicUrl = topicUrl;
	}
	public int getSharedCount() {
		return sharedCount;
	}
	public void setSharedCount(int sharedCount) {
		this.sharedCount = sharedCount;
	}
	public int getLikedCount() {
		return likedCount;
	}
	public void setLikedCount(int likedCount) {
		this.likedCount = likedCount;
	}
	public int getFollowersCount() {
		return followersCount;
	}
	public void setFollowersCount(int followersCount) {
		this.followersCount = followersCount;
	}
	public int getFollowingCount() {
		return followingCount;
	}
	public void setFollowingCount(int followingCount) {
		this.followingCount = followingCount;
	}
	
		
	
}
