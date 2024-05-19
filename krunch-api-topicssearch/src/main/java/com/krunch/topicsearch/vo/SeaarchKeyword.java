package com.krunch.topicsearch.vo;

public class SeaarchKeyword {
	
	private  String  username;
	private  String  keyWord;
	private  String  searchType;
	
	
	public SeaarchKeyword() {
		
		// TODO Auto-generated constructor stub
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getKeyWord() {
		return keyWord;
	}


	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}


	public String getSearchType() {
		return searchType;
	}


	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}


	@Override
	public String toString() {
		return "SeaarchKeyword [username=" + username + ", keyWord=" + keyWord + ", searchType=" + searchType + "]";
	}
	
	
	
}
