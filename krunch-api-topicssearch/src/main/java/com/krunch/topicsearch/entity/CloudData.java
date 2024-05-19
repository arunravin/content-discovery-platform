package com.krunch.topicsearch.entity;

public class CloudData {
	
	String text;
	int weight;
	String link;
	String color;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}

	
	public CloudData() {
		super();
		// TODO Auto-generated constructor stub
	}

}
