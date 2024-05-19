package com.krunch.topicsearch.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krunch.topicsearch.entity.SearchKeyWordData;
import com.krunch.topicsearch.entity.SearchTrendsModel;
import com.krunch.topicsearch.service.KrunchAnalyticsService;
import com.krunch.topicsearch.vo.SeaarchKeyword;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/analytics")
public class KrunchAnalyticsController {

	@Resource
	KrunchAnalyticsService krunchAnalyticsService;
	
	Log log = LogFactory.getLog(getClass());


	@RequestMapping("/pingService")
	public String pingService() {


		return "Y";

	}

	@PostMapping("/keyword")
    public String postSearchKeyword( @RequestBody SeaarchKeyword searchKeyWord )  {
	  
    	log.info("UserName : " + searchKeyWord.getUsername() + "TopicUrl: " + searchKeyWord.getKeyWord()) ;
        return krunchAnalyticsService.postSearchKeyWords(searchKeyWord);
        
    }
	
	@RequestMapping("/search/keywords")
	public List<String> getSearchKeywords() {

		log.info("Enter getSearchKeywords .." );
		return krunchAnalyticsService.getKrunchSearchKeywordsData();

	}
	
	
	@RequestMapping("/search/trends")
	public List<SearchTrendsModel> getSearchTrends(String userName) {

		log.info("Enter getSearch Trends .." );
		return krunchAnalyticsService.getKrunchSearchTrendsData(userName);

	}
	
}
