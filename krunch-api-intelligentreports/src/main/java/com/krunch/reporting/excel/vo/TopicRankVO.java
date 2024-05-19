package com.krunch.reporting.excel.vo;

import com.opencsv.bean.CsvBindByPosition;

public class TopicRankVO {
	
	    @CsvBindByPosition(position = 0)
	    private String topicTitle;

	    @CsvBindByPosition(position = 1)
	    private String topicUrl;

	    @CsvBindByPosition(position = 2)
	    private double topicRank;

	 	@CsvBindByPosition(position = 3)
	    private String personEntity;
	    
	    @CsvBindByPosition(position = 4)
	    private String orgEntity;

	    @CsvBindByPosition(position = 5)
	    private String titleEntity;

		public String getTopicTitle() {
			return topicTitle;
		}

		public void setTopicTitle(String topicTitle) {
			this.topicTitle = topicTitle;
		}

		public String getTopicUrl() {
			return topicUrl;
		}

		public void setTopicUrl(String topicUrl) {
			this.topicUrl = topicUrl;
		}

	
		public String getPersonEntity() {
			return personEntity;
		}

		public void setPersonEntity(String personEntity) {
			this.personEntity = personEntity;
		}

		public String getOrgEntity() {
			return orgEntity;
		}

		public void setOrgEntity(String orgEntity) {
			this.orgEntity = orgEntity;
		}

		public String getTitleEntity() {
			return titleEntity;
		}

		public void setTitleEntity(String titleEntity) {
			this.titleEntity = titleEntity;
		}
		
	   public double getTopicRank() {
			return topicRank;
		}

		public void setTopicRank(double topicRank) {
			this.topicRank = topicRank;
		}

		@Override
		public String toString() {
			return "TopicRankVO [topicTitle=" + topicTitle + ", topicUrl=" + topicUrl + ", topicRank=" + topicRank
					+ ", personEntity=" + personEntity + ", orgEntity=" + orgEntity + ", titleEntity=" + titleEntity
					+ "]";
		}

	    
	    

}
