package com.krunch.topicranking;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.krunch")
public class TopicRankingAlgoApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopicRankingAlgoApplication.class, args);
		
	}

	 	@Bean
	    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
	        return args -> {

	            System.out.println("Let's inspect the beans provided by Spring Boot:");

	            String[] beanNames = ctx.getBeanDefinitionNames();
	            Arrays.sort(beanNames);
	            for (String beanName : beanNames) {
	              //  System.out.println(beanName);
	            }

	        };
	    }
}
