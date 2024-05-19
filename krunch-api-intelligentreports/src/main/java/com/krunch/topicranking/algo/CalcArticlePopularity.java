package com.krunch.topicranking.algo;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.krunch.topicranking.entity.TopicMetaData;
import com.krunch.topicranking.entity.TopicRankingDataModel;
import com.krunch.topicranking.entity.TopicsDataEnricher;

public class CalcArticlePopularity extends AbsTopicRankingAlgo {

	@Override
	public boolean process(TopicRankingDataModel topicDataModel, TopicMetaData topicMetaData) {
		double articlePopularityScore = 0.0;
		
		//System.out.println("TACalculateTweetPopularity%%%%%%%%%%%%%%%%%%%%%%%");
			
		topicDataModel.setFinalScore(topicDataModel.getContentWeightScore() +topicDataModel.getArticleOutBoundLinkScore() 
				+topicDataModel.getArticleOutBoundLinkScore()+topicDataModel.getContentEntitiesScore() 
				+topicDataModel.getDocumentRelevancy()+topicDataModel.getTopicPopularityScore());
		
		articlePopularityScore = calculateTweetPopularity(topicDataModel,topicMetaData);
		topicDataModel.setTopicPopularityScore(articlePopularityScore);
		if(topicDataModel.getFinalScore()>=4.8) {
			
			System.out.println(topicDataModel.getOgTitle().replace(",","")+ "," + topicDataModel.getOgUrl()+"," 
					+ topicDataModel.getFinalScore() + "," + topicDataModel.getPersonEntities() + "," + topicDataModel.getOrganizationEntities()
					+ "," + topicDataModel.getTitleEntities())  ;
			
			try {
				
				String topicTitle = topicDataModel.getOgTitle().replace(",","");
				topicTitle =  topicTitle.replaceAll("\"","\\\"");
				
				topicMetaData.getCsvFileWriter().append(topicTitle+ "," + topicDataModel.getOgUrl()+"," 
						+ topicDataModel.getFinalScore() + "," + topicDataModel.getPersonEntities() + "," + topicDataModel.getOrganizationEntities()
						+ "," + topicDataModel.getTitleEntities());
				topicMetaData.getCsvFileWriter().append("\n");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
			//	System.out.println("**************END*************");
		
		set_topicRankingResult(topicDataModel);
		
		
		return checkNextHandler(topicDataModel, topicMetaData);
	}
	
	static double calculateTweetPopularity(TopicRankingDataModel topicDataModel, TopicMetaData topicMetaData){
		
		double dblPopularityScore = 0.0;
		
		List<TopicsDataEnricher> lstTopicsTxnMetaData = topicMetaData.getTopicsTxnMetaData();
		
		List<TopicsDataEnricher> filteredData = lstTopicsTxnMetaData.stream().filter(tmd -> tmd.getTopicUrl().
				equals(topicDataModel.getTopicSourceUrl())).collect(Collectors.toList());
		 
		int maxSharedCount =0;;
		int maxLikedCount=0;
		try {
			maxSharedCount = filteredData.stream().mapToInt(s -> s.getSharedCount()).max().getAsInt();
			maxLikedCount =  filteredData.stream().mapToInt(s -> s.getLikedCount()).max().getAsInt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		/*
		TopicsDataEnricher tdr = filteredData
			      .stream()
			      .max(Comparator.comparing(TopicsDataEnricher::getFollowersCount))
			      .orElseThrow(NoSuchElementException::new);
		**/
		
	//	System.out.println("Maximum Shared Count : " + maxSharedCount);
		
		int tweetPopularity = maxSharedCount + maxLikedCount;
		
		if(tweetPopularity<=50) dblPopularityScore= tweetPopularity/5;
		if(tweetPopularity>=51) dblPopularityScore= 15;
		
		return dblPopularityScore;
	}
	
	
	/*
	 * select max("SharedCount") as sharedcount , max("LikedCount") as maxlikedcount ,
Round(avg("FollowersCount")) as "avgfollowerscount", Round(avg("FollowingCount")) as "avgfollowingcount"
from "Topics" where 
"TopicUrl" ='https://t.her.is/2PJ8XSj'

SELECT *
FROM ts_stat($$
  SELECT to_tsvector(t."TopicOgUrlContent")
  FROM "TopicEntityData" AS t where 
			 "TopicSourceUrl"='https://bit.ly/3mi87Yz' 
	$$)  order by nentry desc;
	 */
	

}
