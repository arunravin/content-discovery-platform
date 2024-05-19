package com.krunch.topicsearch.recommendations.json;

import java.util.ArrayList;
import java.util.List;

public class DataContainer {
	
	private Data data;
	private List<Children> children = new ArrayList<Children>();
	
	
	
	public DataContainer(Data data, List<Children> children) {
		super();
		this.data = data;
		this.children = children;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	public List<Children> getChildren() {
		return children;
	}
	public void setChildren(List<Children> children) {
		this.children = children;
	}
	
	
}
