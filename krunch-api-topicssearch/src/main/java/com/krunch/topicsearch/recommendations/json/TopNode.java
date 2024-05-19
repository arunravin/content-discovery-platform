package com.krunch.topicsearch.recommendations.json;

import java.util.ArrayList;
import java.util.List;

public class TopNode {
	
	List<Children> children = new ArrayList<Children>();

	public List<Children> getChildren() {
		return children;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
	}

	public TopNode(List<Children> children) {
		super();
		this.children = children;
	}
	
	
}
