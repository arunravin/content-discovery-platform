package com.krunch.topicsearch.entity;

public class SearchKeyWordData {
	
	String searchKeyword;
	int count;
	String userName;
	String searchType;
	
	
	public String getSearchKeyword() {
		return searchKeyword;
	}


	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}


	public int getCount() {
		return count;
	}


	public void setCount(int count) {
		this.count = count;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	public SearchKeyWordData() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public String toString() {
		return "SearchKeyWordData [searchKeyword=" + searchKeyword + ", count=" + count + ", userName=" + userName
				+ ", searchType=" + searchType + "]";
	}

}
