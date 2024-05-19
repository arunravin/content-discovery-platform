package com.krunch.topicranking.algo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.krunch.reporting.IntelligentReports;
import com.krunch.reporting.TopicReportFactory;
import com.krunch.reporting.excel.vo.TopicRankVO;
import com.krunch.topicranking.dao.TopicsDataRepositoryPgImpl;
import com.krunch.topicranking.dao.TopicsQueryBuilder;
import com.krunch.topicranking.entity.TopicMetaData;
import com.krunch.topicranking.entity.TopicRankingDataModel;
import com.krunch.topicranking.entity.TopicsDataEnricher;
import com.opencsv.bean.CsvToBeanBuilder;

@Component
public class TopicRankingPipeline {

	AbsTopicRankingAlgo pipeLine;

	@Resource
	TopicsDataRepositoryPgImpl topicsDataDao;

	List<TopicRankingDataModel> lstTopics;
	List<TopicsDataEnricher> lstTopicsEnrichedData;

	public static void main(String[] args) throws Exception {
		TopicRankingPipeline tp = new TopicRankingPipeline();
		tp.buildPipeLine("microservices");
		tp.initProcessData("microservices", 7);
		tp.executePipelines("microservices");

	}

	public TopicRankingPipeline() {
		System.out.println("Constructor Invoked .. ");

	}

	public void buildPipeLine(String topicName) {

		try {
			pipeLine = new CalcArticleOutBoundLinksStrength(topicName);

			pipeLine.linkWith(new CalcArticleContentQuality()).linkWith(new CalcDocEntitiesImportance())
					.linkWith(new CalcDocRelevancy()).linkWith(new CalcArticlePopularity()).linkWith(null);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initProcessData(String topicName, int timeIntervalfromToday) {

		lstTopics = topicsDataDao.findByTopicbyEntityType(topicName, timeIntervalfromToday);
		lstTopicsEnrichedData = topicsDataDao.enrichTopicsdata(topicName, timeIntervalfromToday);
	}

	public void executePipelines(String topicName) throws Exception {

		List<TopicRankingDataModel> lstFinalOutput = new ArrayList<TopicRankingDataModel>();
		TopicMetaData topicMetaData = getTopicMetaData(topicName);

		Iterator<TopicRankingDataModel> iter = lstTopics.iterator();
		while (iter.hasNext()) {
			TopicRankingDataModel topic = iter.next();
			// System.out.println(topic.getOgTitle() + " :: " + topic.getOgUrl());
			this.pipeLine.process(topic, topicMetaData);
		}
		System.out.println("Execute Pipeline Completed ***** .. ");
		generateTopicReports(topicMetaData, 0);

	}

	private void generateTopicReports(TopicMetaData topicMetaData, int reportType)
			throws IOException, FileNotFoundException {
		topicMetaData.getCsvFileWriter().close();

		List<TopicRankVO> lstTopicReportdata = new CsvToBeanBuilder(new FileReader(topicMetaData.getFileName()))
				.withType(TopicRankVO.class).build().parse();

		TopicReportFactory topicReportFactory = new TopicReportFactory();
		IntelligentReports intelligentReports = topicReportFactory.generateTopicReport(1);
		lstTopicReportdata.forEach(System.out::println);
		boolean blnGenerated = intelligentReports.generateTopicReport(lstTopicReportdata, topicMetaData.getTopicName());
		
	}

	private TopicMetaData getTopicMetaData(String topicName) throws Exception {

		TopicsQueryBuilder tpsqb = new TopicsQueryBuilder();

		String topicKeyWords = tpsqb.getTopicKeyWords(topicName);
		String topicKeyTitles = tpsqb.getTopicKeyTitles(topicName);
		String topicKeyOrganizations = tpsqb.getTopicKeyOrgs(topicName);
		String topicKeyInfluencers = tpsqb.getTopicKeyInfluencers(topicName);

		TopicMetaData topicMetaData = new TopicMetaData();
		topicMetaData.setTopicName(topicName);
		topicMetaData.setTopicKeywords(topicKeyWords);
		topicMetaData.setTopicOrganizations(topicKeyOrganizations);
		topicMetaData.setTopicTitles(topicKeyTitles);
		topicMetaData.setTopicInfluencers(topicKeyInfluencers);
		topicMetaData.setTopicsTxnMetaData(lstTopicsEnrichedData);

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		System.out.println(dateFormat.format(cal.getTime()));
		String csvFilename = topicName + "_" + dateFormat.format(cal.getTime()) + ".csv";
		FileWriter csvwriter = new FileWriter(csvFilename);

		topicMetaData.setCsvFileWriter(csvwriter);
		topicMetaData.setFileName(csvFilename);
		return topicMetaData;
	}

}
