package com.krunch.reporting;

import java.util.List;

import com.krunch.reporting.excel.vo.TopicRankVO;

public interface IntelligentReports {
	
	boolean generateTopicReport(List<TopicRankVO> lstTopicReportData, String topicName); 
	
	

}
