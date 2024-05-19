package com.krunch.topicsearch.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.krunch.topicsearch.dao.TopicWordCloudRepositoryPgImpl;
import com.krunch.topicsearch.entity.CloudData;

@Component
public class TopicWordCloudServiceImpl implements TopicWordCloudService {

	@Resource
	TopicWordCloudRepositoryPgImpl wordCLoudDataDao;

	Log log = LogFactory.getLog(getClass());

	@Override
	public List<CloudData> getTopicsWordCloud(String topicName) {
		List<CloudData> lstWordCLoudData = wordCLoudDataDao.getTopicWordCloudData(topicName);
		return lstWordCLoudData;
	}

	@Override
	public List<CloudData> getPersonTopicsWordCloud(String topicName) {
		List<CloudData> lstWordCLoudData = wordCLoudDataDao.getPersonTopicWordCloudData(topicName);
		return lstWordCLoudData;
	}

	@Override
	@Cacheable(cacheNames = "entitiesCache", key = "#topicName")
	public List<CloudData> getTopicNameWordCloud(String topicName) {

		log.info("*******************************************" + topicName);

		List<CloudData> _lstCloudDataResponse = new ArrayList<CloudData>();

		List<String> lstOrgEntities = wordCLoudDataDao.getTopicNameWordCloudData(topicName);

		HashMap<String, Integer> hmWordCloudData = extractWordCLoudData(lstOrgEntities);
		/*
		 * hmWordCloudData.remove("Microsoft"); hmWordCloudData.remove("Amazon");
		 * hmWordCloudData.remove("Google");
		 **/
		int i = 0;

		for (Map.Entry<String, Integer> sortedEntry : hmWordCloudData.entrySet()) {

			// log.info(sortedEntry.getKey() + " : " + sortedEntry.getValue());

			CloudData wordCloudVO = new CloudData();

			wordCloudVO.setText(sortedEntry.getKey());
			wordCloudVO.setWeight(sortedEntry.getValue());

			_lstCloudDataResponse.add(wordCloudVO);

			++i;

			if (i > 99)
				break;

		}

		return _lstCloudDataResponse;
	}

	@Override
	@Cacheable(cacheNames = "personsCache", key = "#topicName")
	public List<CloudData> getPersonWordCloud(String topicName) {

		log.info("*******************************************" + topicName);

		List<CloudData> _lstCloudDataResponse = new ArrayList<CloudData>();

		List<String> lstOrgEntities = wordCLoudDataDao.getTopicPersonWordCloudData(topicName);

		HashMap<String, Integer> hmWordCloudData = extractWordCLoudData(lstOrgEntities);

		hmWordCloudData.remove("He");
		hmWordCloudData.remove("he");
		hmWordCloudData.remove("HE");
		hmWordCloudData.remove("She");
		hmWordCloudData.remove("she");
		hmWordCloudData.remove("SHE");
		hmWordCloudData.remove("Him");
		hmWordCloudData.remove("him");
		hmWordCloudData.remove("His");
		hmWordCloudData.remove("his");
		hmWordCloudData.remove("Her");
		hmWordCloudData.remove("her");
		/*
		 * hmWordCloudData.remove("Microsoft"); hmWordCloudData.remove("Amazon");
		 * hmWordCloudData.remove("Google"); hmWordCloudData.remove("Hadoop");
		 * hmWordCloudData.remove("Deloitte"); hmWordCloudData.remove("Siri");
		 * hmWordCloudData.remove("DeepMind"); hmWordCloudData.remove("Accenture");
		 * hmWordCloudData.remove("Linkedin");
		 **/

		int i = 0;

		for (Map.Entry<String, Integer> sortedEntry : hmWordCloudData.entrySet()) {

			// log.info(sortedEntry.getKey() + " : " + sortedEntry.getValue());

			CloudData wordCloudVO = new CloudData();

			String strPersonName = sortedEntry.getKey().strip();

			if (strPersonName.indexOf(" ") > 0) {

				wordCloudVO.setText(sortedEntry.getKey());
				wordCloudVO.setWeight(sortedEntry.getValue());
				_lstCloudDataResponse.add(wordCloudVO);
				++i;

				if (i > 99)
					break;

			}

		}

		return _lstCloudDataResponse;
	}

	private HashMap<String, Integer> extractWordCLoudData(List<String> lstOrgEntities) {
		int updatedKeyCount;
		HashMap<String, Integer> _hmWordCloudData = new HashMap<String, Integer>();

		for (String temp : lstOrgEntities) {

			if (temp.indexOf("|") > 0) {
				String[] entitiesArray = org.apache.commons.lang3.StringUtils.split(temp, "|");

				for (String strIndividualEntity : entitiesArray) {
					strIndividualEntity = strIndividualEntity.trim();

					if (_hmWordCloudData.containsKey(strIndividualEntity)) {
						int value = _hmWordCloudData.get(strIndividualEntity);
						updatedKeyCount = value + 1;
						_hmWordCloudData.put(strIndividualEntity, updatedKeyCount);

					} else {

						_hmWordCloudData.put(strIndividualEntity, 1);

					}
				}

			} else {
				String strEntity = temp;
				strEntity = strEntity.trim();
				if (_hmWordCloudData.containsKey(strEntity)) {
					int value = _hmWordCloudData.get(strEntity);
					updatedKeyCount = value + 1;
					_hmWordCloudData.put(strEntity, updatedKeyCount);

				} else {

					_hmWordCloudData.put(strEntity, 1);

				}

			}

		}

		HashMap<String, Integer> _hmSortedWordCloudData = sortByValue(_hmWordCloudData);

		return _hmSortedWordCloudData;
	}

	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) {

		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(hm.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o2.getValue()).compareTo(o1.getValue());
			}
		});

		HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}

		return temp;
	}

}
