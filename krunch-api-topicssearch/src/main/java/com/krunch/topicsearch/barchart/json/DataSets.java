package com.krunch.topicsearch.barchart.json;

public class DataSets {
	
	String backgroundColor	 = "rgba(89,139,255,0.8)";
	int[] data = {10, 20, 30, 40,50};
	String label = "Reading Trend";

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public int[] getData() {
		return data;
	}

	public void setData(int[] data) {
		this.data = data;
	}


	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public DataSets(String label,int[] data,String backgroundColor ) {
		super();
		this.backgroundColor = backgroundColor;
		this.data = data;
		
	}
}