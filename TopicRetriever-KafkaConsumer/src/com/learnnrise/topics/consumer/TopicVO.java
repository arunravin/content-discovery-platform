package com.learnnrise.topics.consumer;

/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.io.Serializable;
import java.util.Date;



public class TopicVO implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;
	private String originalText;
	private String transformedText;
	private Date createdAt;
	private int retweetCount;
	private int favoriteCount;
	private String topicUrl;
	private String topicTags;
	private int sharedCount;
	private int likedCount;
	private String location;
	private int followersCount;
	private int followingCount;
	
	//long,String,int,Date
	
	public TopicVO() {
		
	}
	
	public TopicVO(long id, String originalText, String transformedText, Date createdAt, int retweetCount,
			int favoriteCount, String topicUrl, String topicTags, int sharedCount, int likedCount, String location,
			int followersCount, int followingCount) {
		super();
		this.id = id;
		this.originalText = originalText;
		this.transformedText = transformedText;
		this.createdAt = createdAt;
		this.retweetCount = retweetCount;
		this.favoriteCount = favoriteCount;
		this.topicUrl = topicUrl;
		this.topicTags = topicTags;
		this.sharedCount = sharedCount;
		this.likedCount = likedCount;
		this.location = location;
		this.followersCount = followersCount;
		this.followingCount = followingCount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getOriginalText() {
		return originalText;
	}
	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}
	public String getTransformedText() {
		return transformedText;
	}
	public void setTransformedText(String transformedText) {
		this.transformedText = transformedText;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public int getRetweetCount() {
		return retweetCount;
	}
	public void setRetweetCount(int retweetCount) {
		this.retweetCount = retweetCount;
	}
	public int getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public String getTopicUrl() {
		return topicUrl;
	}
	public void setTopicUrl(String topicUrl) {
		this.topicUrl = topicUrl;
	}
	public String getTopicTags() {
		return topicTags;
	}
	public void setTopicTags(String topicTags) {
		this.topicTags = topicTags;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + favoriteCount;
		result = prime * result + followersCount;
		result = prime * result + followingCount;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + likedCount;
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		result = prime * result + ((originalText == null) ? 0 : originalText.hashCode());
		result = prime * result + retweetCount;
		result = prime * result + sharedCount;
		result = prime * result + ((topicTags == null) ? 0 : topicTags.hashCode());
		result = prime * result + ((topicUrl == null) ? 0 : topicUrl.hashCode());
		result = prime * result + ((transformedText == null) ? 0 : transformedText.hashCode());
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
		TopicVO other = (TopicVO) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (favoriteCount != other.favoriteCount)
			return false;
		if (followersCount != other.followersCount)
			return false;
		if (followingCount != other.followingCount)
			return false;
		if (id != other.id)
			return false;
		if (likedCount != other.likedCount)
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		if (originalText == null) {
			if (other.originalText != null)
				return false;
		} else if (!originalText.equals(other.originalText))
			return false;
		if (retweetCount != other.retweetCount)
			return false;
		if (sharedCount != other.sharedCount)
			return false;
		if (topicTags == null) {
			if (other.topicTags != null)
				return false;
		} else if (!topicTags.equals(other.topicTags))
			return false;
		if (topicUrl == null) {
			if (other.topicUrl != null)
				return false;
		} else if (!topicUrl.equals(other.topicUrl))
			return false;
		if (transformedText == null) {
			if (other.transformedText != null)
				return false;
		} else if (!transformedText.equals(other.transformedText))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TopicVO [id=" + id + ", originalText=" + originalText + ", transformedText=" + transformedText
				+ ", createdAt=" + createdAt + ", retweetCount=" + retweetCount + ", favoriteCount=" + favoriteCount
				+ ", topicUrl=" + topicUrl + ", topicTags=" + topicTags + ", sharedCount=" + sharedCount
				+ ", likedCount=" + likedCount + ", location=" + location + ", followersCount=" + followersCount
				+ ", followingCount=" + followingCount + "]";
	}

	

	


}
