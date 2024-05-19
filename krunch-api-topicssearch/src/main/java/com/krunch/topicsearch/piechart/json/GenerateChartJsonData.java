package com.krunch.topicsearch.piechart.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class GenerateChartJsonData {
	
	String[] labels;
	int[] intdata ;
	String[] backgroundColor;
	
	
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

	public String[] getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String[] backgroundColor) {
		this.backgroundColor = backgroundColor;
	}


	public static void main(String[] args) throws Exception {
		
	GenerateChartJsonData genPieChartData = new GenerateChartJsonData();
	
	genPieChartData.getPieChartDataJson();
	}
	
	
	
	public  String getPieChartDataJson() {
		String[] labels = { "Liked", "Read", "Sharing Intent", "Not Interested", "Further Exploration" };
	//	int[] intdata = { 10, 20, 30, 40, 50 };
		String[] backgroundColor = { 
				"rgba(255, 56, 56,1.0)", 
				"rgba(24, 220, 255,1.0)",
				"rgba(255, 159, 243,1.0)",
				"rgba(61, 61, 61,1.0)",
				"rgba(255, 250, 101,1.0)" };

		List<DataSets> datasets = new ArrayList<DataSets>();
		datasets.add(new DataSets(intdata, backgroundColor));

		Data data = new Data( labels, datasets);

		Gson gson = new Gson();
		String finalJson = gson.toJson(data);

		System.out.println(finalJson);
		return finalJson;
	}




}
