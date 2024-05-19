package com.twitter.producer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;


public class KafkaProducer {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void send(String topic, String key,String payload) {
       // log.info("Key for the Payload'" + key +" : "+ payload);
        kafkaTemplate.send(topic,key,payload);
        
    }
}
