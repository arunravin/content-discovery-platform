package com.krunch.topicsearch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicsearch.entity.SearchKeyWordData;

public class KrunchAnalyticsMapper implements RowMapper<String>{

	@Override
	public String mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		SearchKeyWordData searchKeywordData = new SearchKeyWordData();
		
		searchKeywordData.setCount(rs.getInt("Count"));  
		String strKeyWord= rs.getString("Search_Keyword");
		
		return strKeyWord;
	}
	
}
