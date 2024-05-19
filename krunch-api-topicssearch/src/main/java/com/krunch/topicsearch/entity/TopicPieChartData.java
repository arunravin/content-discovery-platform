package com.krunch.topicsearch.entity;

public class TopicPieChartData {
	
	private int tcount;
	private String engagementType;
	
	
	public int getTcount() {
		return tcount;
	}
	public void setTcount(int tcount) {
		this.tcount = tcount;
	}
	public String getEngagementType() {
		return engagementType;
	}
	public void setEngagementType(String engagementType) {
		this.engagementType = engagementType;
	}
	
	@Override
	public String toString() {
		return "TopicPieChartData [tcount=" + tcount + ", engagementType=" + engagementType + "]";
	}
	
	
}
