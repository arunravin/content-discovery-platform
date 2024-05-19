package com.krunch.topicranking.algo;

import com.krunch.topicranking.entity.TopicMetaData;
import com.krunch.topicranking.entity.TopicRankingDataModel;

public class CalcDocEntitiesImportance extends AbsTopicRankingAlgo {

	@Override
	public boolean process(TopicRankingDataModel topicDataModel, TopicMetaData topicMetaData) {

	//	System.out.println(topicDataModel.getOrganizationEntities() + ":" + topicDataModel.getPersonEntities() + ":"
	//			+ topicDataModel.getTitleEntities());

		double documentEntitiesScore = 0.0;
		// Check whether thee URL host contains key websites
		// Check the titles , organizations and influencers

		documentEntitiesScore = calculateTitleStrength(topicDataModel.getTitleEntities(),
				topicMetaData.getTopicTitles());

		documentEntitiesScore = documentEntitiesScore
				+ calculateInfluencersStrength(topicDataModel.getPersonEntities(), topicMetaData.getTopicInfluencers());

		documentEntitiesScore = documentEntitiesScore
				+ calculateOrgStrength(topicDataModel.getOrganizationEntities(), topicMetaData.getTopicOrganizations());

	
		topicDataModel.setContentEntitiesScore(documentEntitiesScore);
		
	//	System.out.println("Entities score "+ documentEntitiesScore);

		return checkNextHandler(topicDataModel, topicMetaData);

	}

	static double calculateTitleStrength(String titleEntities, String topicTitles) {
		double titleEntitiesScore = 0.0;

		String[] arrTopicTitles = topicTitles.split("\\|");

		for (String topicTitle : arrTopicTitles) {

			if (titleEntities!=null && !titleEntities.isEmpty() && titleEntities.toLowerCase().contains(topicTitle)) {

				titleEntitiesScore = titleEntitiesScore + 0.25;
				// System.out.println("OutBound Links containes Keywords : " +
				// outBoundLinksScore);

			}
		}

		return titleEntitiesScore;

	}

	static double calculateInfluencersStrength(String personEntities, String influencers) {
		double personEntitiesScore = 0.0;

		String[] arrTopicInfluencerss = influencers.split("\\|");

		for (String topicInfluencere : arrTopicInfluencerss) {

			if (personEntities!=null && !personEntities.isEmpty() && personEntities.toLowerCase().contains(topicInfluencere)) {

				personEntitiesScore = personEntitiesScore + 1.0;
				// System.out.println("OutBound Links containes Keywords : " +
				// outBoundLinksScore);

			}
		}

		return personEntitiesScore;

	}

	static double calculateOrgStrength(String orgEntities, String organizations) {
		double orgEntitiesScore = 0.0;

		String[] arrTopicInfluencerss = organizations.split("\\|");

		for (String topicInfluencere : arrTopicInfluencerss) {

			if (orgEntities!=null && !orgEntities.isEmpty() && orgEntities.toLowerCase().contains(topicInfluencere)) {

				orgEntitiesScore = orgEntitiesScore + 1.0;
				// System.out.println("OutBound Links containes Keywords : " +
				// outBoundLinksScore);

			}
		}

		return orgEntitiesScore;

	}

	

}
