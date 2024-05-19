package com.krunch.topicsearch.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.krunch.topicsearch.entity.SearchTrendsModel;
import com.krunch.topicsearch.mapper.KrunchAnalyticsMapper;
import com.krunch.topicsearch.mapper.KrunchSearchTrendsMapper;
import com.krunch.topicsearch.querybuilder.SearchTrendsQueryBuilder;
import com.krunch.topicsearch.vo.SeaarchKeyword;

@Repository
public  class KrunchAnalyticsRepositoryPgImpl implements KrunchAnalyticsRepository {

	public KrunchAnalyticsRepositoryPgImpl(NamedParameterJdbcTemplate template) {
		this.template = template;
	}

	NamedParameterJdbcTemplate template;
	
	Log log = LogFactory.getLog(getClass());

	
	final String TOPIC_SEARCH_KEYWORDS_INSERT_QUERY = "INSERT INTO public.\"User_Topics_Search_Keywords\"(\n" + 
			"	\"Keyword\", \"UserName\", \"CreatedAt\",\"SearchType\")\n" + 
			"	VALUES (:keyword, :username,:createdat,:searchtype);";


	@Override
	public List<String> getKrunchSearchKeywordsData() {
		
		String strKeyWordSearchSQL = "select INITCAP(\"Keyword\") as \"Search_Keyword\",count(INITCAP(\"Keyword\")) as count \n" + 
				" 	from \"User_Topics_Search_Keywords\"  \n" + 
				" 		where \"is_Valid\" ='Y'\n" + 
				"			group by INITCAP(\"Keyword\")  \n" + 
				"				order by count desc";
		
		log.info("Query To be Executed : " + strKeyWordSearchSQL);

		List<String> lstSearchKeyWords = template.query(strKeyWordSearchSQL,
				new KrunchAnalyticsMapper());

		return lstSearchKeyWords;
		
			}



	@Override
	public String postSearchKeyWords(SeaarchKeyword searckKeyWordVO) {
		
		log.info(searckKeyWordVO.toString());
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
	    paramMap.put("keyword", searckKeyWordVO.getKeyWord() );
	    paramMap.put("username", searckKeyWordVO.getUsername() );
	    paramMap.put("createdat",  new Timestamp(new Date().getTime()) );
	    paramMap.put("searchtype",  searckKeyWordVO.getSearchType() );
	    int result = template.update(TOPIC_SEARCH_KEYWORDS_INSERT_QUERY, paramMap);
		return Integer.toString(result);
	}



	@Override
	public List<SearchTrendsModel> getKrunchSearchTrendsData(String userName) {
		
		String userSearchTrendsQuery = SearchTrendsQueryBuilder.genSearchTrendsQuery(userName);
		
		log.info(userSearchTrendsQuery);
		
		List<SearchTrendsModel> lstSearchTrends = template.query(userSearchTrendsQuery,
				new KrunchSearchTrendsMapper());
		
		return lstSearchTrends;
		
		  
	}
	

	
}
