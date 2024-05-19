package com.krunch.topicsearch.recommendations.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class GenerateRecommendationsJsonData {

	public static void main(String[] args) {
		
		String userName="$arunravin@gmaill.com";
		
		if (userName!=null && userName.startsWith("$")) {
			userName= userName.substring(userName.indexOf("$")+1,userName.length());
		}
		
		System.out.println(userName);
		System.exit(1);
		
		JsonObject jsonObject = new JsonObject();
	      //Inserting key-value pairs into the json object
        jsonObject.addProperty("name", "Title");
        jsonObject.addProperty("type", "Description Value");
        jsonObject.addProperty("url", "URL Value");
	
        	

	}

	
	
	String generateTreeNodeJson() {
		
		return null;
	}
	
	String generateNodeExpandChildrenJson() {
		
		return null;
	}
}
