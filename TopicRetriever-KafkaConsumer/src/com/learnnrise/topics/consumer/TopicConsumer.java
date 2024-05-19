package com.learnnrise.topics.consumer;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.learn2rise.topics.dao.TopicsBatchProcessor;

public class TopicConsumer {

	public static void main(String[] args) {

		Logger logger = LoggerFactory.getLogger(TopicConsumer.class.getName());
	
		
		String bootstrapServers = "localhost:9092";
		String grp_id = "persist_data";
		String topic = "tweets";
		
		// Creating consumer properties
		Properties properties = new Properties();
		properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, grp_id);
		properties.setProperty(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
		
		// creating consumer
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
		// Subscribing
		consumer.subscribe(Arrays.asList(topic));
		
		List<TopicVO> dataContainer = new ArrayList<TopicVO>();
		// polling
		while (true) {
			ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(300000).toMillis());
			
			for (ConsumerRecord<String, String> record : records) {
				if(dataContainer==null)dataContainer = new ArrayList<TopicVO>();
			//	System.out.println("Key: " + record.key() + ", Value:" + record.value());
			//	System.out.println("Partition:" + record.partition() +  ",Offset:" + record.offset());
				
				Gson payLoadJson = new Gson();
			    TopicVO topicVO = payLoadJson.fromJson(record.value(), TopicVO.class);
			    dataContainer.add(topicVO);
				
			  //  System.out.println("****************** INSIDE LOOP ******************** "+ topicVO.toString());
			  //  System.out.println(topicVO.toString());
			}
	
			if(dataContainer!=null)	System.out.println("Data Container Size " + dataContainer.size());
			
			 if(dataContainer!=null && dataContainer.size()>50) {
				 TopicsBatchProcessor.parameterizedBatchUpdate(dataContainer) ;
				 dataContainer=null;
			 }
	
		}

	}

}
