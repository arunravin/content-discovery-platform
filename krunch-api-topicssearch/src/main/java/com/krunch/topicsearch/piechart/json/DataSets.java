package com.krunch.topicsearch.piechart.json;

public class DataSets {
	
	
	String[] backgroundColor	 = {"rgba(46, 204, 113,1.0)", "rgba(255, 242, 0,1.0)",
									"rgba(44, 44, 84,1.0)","rgba(205, 97, 51,1.0)",
									  "rgba(61, 61, 61,1.0)"};
	
	int[] data = {10, 20, 30, 40,50};
	
		
	public String[] getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String[] backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public DataSets(int[] data,String[] backgroundColor ) {
		super();
		this.backgroundColor = backgroundColor;
		this.data = data;
	}

	public DataSets(String label,int[] data,String[] backgroundColor ) {
		super();
		this.backgroundColor = backgroundColor;
		this.data = data;
		
	}
}