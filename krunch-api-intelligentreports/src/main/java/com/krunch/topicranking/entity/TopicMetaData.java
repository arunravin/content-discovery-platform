package com.krunch.topicranking.entity;

import java.io.FileWriter;
import java.util.List;

public class TopicMetaData {
	
	
	private String topicName ;
	private String topicKeywords;
	private String topicTitles;
	private String topicInfluencers;
	private String topicOrganizations;
	private List<TopicsDataEnricher> topicsTxnMetaData;

	private String fileName ;
	private FileWriter csvFileWriter ;

	

	public FileWriter getCsvFileWriter() {
		return csvFileWriter;
	}

	public void setCsvFileWriter(FileWriter csvFileWriter) {
		this.csvFileWriter = csvFileWriter;
	}

	public List<TopicsDataEnricher> getTopicsTxnMetaData() {
		return topicsTxnMetaData;
	}

	public void setTopicsTxnMetaData(List<TopicsDataEnricher> topicsTxnMetaData) {
		this.topicsTxnMetaData = topicsTxnMetaData;
	}

	public String getTopicKeywords() {
		return topicKeywords;
	}

	public void setTopicKeywords(String topicKeywords) {
		this.topicKeywords = topicKeywords;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}
	
	public String getTopicTitles() {
		return topicTitles;
	}

	public void setTopicTitles(String topicTitles) {
		this.topicTitles = topicTitles;
	}

	public String getTopicInfluencers() {
		return topicInfluencers;
	}

	public void setTopicInfluencers(String topicInfluencers) {
		this.topicInfluencers = topicInfluencers;
	}

	public String getTopicOrganizations() {
		return topicOrganizations;
	}

	public void setTopicOrganizations(String topicOrganizations) {
		this.topicOrganizations = topicOrganizations;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
}
