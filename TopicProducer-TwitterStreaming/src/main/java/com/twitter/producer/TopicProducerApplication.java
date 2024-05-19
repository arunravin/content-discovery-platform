package com.twitter.producer;

import com.twitter.producer.service.TwitterStreamingService;

import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@SpringBootApplication
@EnableAsync
public class TopicProducerApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(TopicProducerApplication.class);

    private TwitterStreamingService twitterStreamingService;

    public TopicProducerApplication(TwitterStreamingService twitterStreamingService) {
        this.twitterStreamingService = twitterStreamingService;
    }

    public static void main(String[] args) {
        SpringApplication.run(TopicProducerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        logger.info("Running Twitter Streaming ...");
        twitterStreamingService.stream();
    }
    
    @Bean
    public Executor taskExecutor() {
      ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
      executor.setCorePoolSize(2);
      executor.setMaxPoolSize(2);
      executor.setQueueCapacity(500);
      executor.setThreadNamePrefix("Postgres");
      executor.initialize();
      return executor;
    }

}
