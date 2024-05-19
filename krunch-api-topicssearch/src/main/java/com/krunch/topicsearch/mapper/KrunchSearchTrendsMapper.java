package com.krunch.topicsearch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicsearch.entity.SearchKeyWordData;
import com.krunch.topicsearch.entity.SearchTrendsModel;

public class KrunchSearchTrendsMapper implements RowMapper<SearchTrendsModel>{

	@Override
	public SearchTrendsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SearchTrendsModel searchTrendsModel = new SearchTrendsModel();
		//"Keyword" ,Date("CreatedAt") as date, count("Keyword") as 
		searchTrendsModel.setMytopics(rs.getString("Keyword"));
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String strDate = dateFormat.format(rs.getDate("date1"));  
		searchTrendsModel.setDate(strDate);
		
	//	System.out.println(searchTrendsModel.toString()); 
		
		return searchTrendsModel;
	}
	
}
