package com.krunch.topicsearch.recommendations.json;

public class Data {
	
	String name;
	String type;
	String url;
	
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public Data(String name, String type, String url) {
		super();
		this.name = name;
		this.type = type;
		this.url = url;
	}
	
	
	
		
}
