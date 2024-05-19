package com.krunch.topicsearch.piechart.json;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class Data {

	String[] labels;
	List<DataSets> datasets;

	public Data(String[] labels, List<DataSets> lstdata) {
		super();
		this.labels = labels;
		this.datasets = lstdata;
	}

}
