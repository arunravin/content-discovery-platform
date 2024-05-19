package com.krunch.topicsearch.barchart.json;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

public class GenerateBarChartJsonData {
	
	String[] labels;
	int[] intdata ;
	String backgroundColor;
	
	
	public String[] getLabels() {
		return labels;
	}

	public void setLabels(String[] labels) {
		this.labels = labels;
	}

	public int[] getIntdata() {
		return intdata;
	}

	public void setIntdata(int[] intdata) {
		this.intdata = intdata;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}


	public static void main(String[] args) throws Exception {
		
	GenerateBarChartJsonData genBarChartData = new GenerateBarChartJsonData();
	
	genBarChartData.getBarChartDataJson();
	}
	
	
	
	public  String getBarChartDataJson() {
		/*
		String[] labels = { "Liked", "Read", "Sharing Intent", "Not Interested", "Further Exploration" };
		int[] intdata = { 10, 20, 30, 40, 50 };
		String backgroundColor = "NbColorHelper.hexToRgbA(colors.primaryLight, 0.8)";
		String label="What's Achieved";
		 **/
		String label="No of articles/topics read";
		List<DataSets> datasets = new ArrayList<DataSets>();
		datasets.add(new DataSets(label,intdata, backgroundColor));

		Data data = new Data( labels, datasets);

		Gson gson = new Gson();
		String finalJson = gson.toJson(data);

		System.out.println(finalJson);
		return finalJson;
	}
	
	public  String getTrendsDataJson() {
		String label="Reading Trend : " +  Arrays.toString(intdata);
		List<DataSets> datasets = new ArrayList<DataSets>();
		datasets.add(new DataSets(label ,intdata, backgroundColor));

	
		Gson gson = new Gson();
		String finalJson = gson.toJson(intdata);
		return finalJson;
	}




}
