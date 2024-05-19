package com.krunch.topicsearch;

import java.util.List;
import java.util.concurrent.Executor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCaching
@EnableEurekaClient
@EnableAsync
public class KnowledgeAccelarationApplication {
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}


	public static void main(String[] args) {
		SpringApplication.run(KnowledgeAccelarationApplication.class, args);
		
	}
	
	@Bean
	  public Executor taskExecutor() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(2);
	    executor.setMaxPoolSize(2);
	    executor.setQueueCapacity(500);
	    executor.setThreadNamePrefix("Krunch-");
	    executor.initialize();
	    return executor;
	  }

	 @Bean
	    public CommandLineRunner commandLineRunner(RestTemplate restTemplate) {
	        return args -> {

	        	System.out.println("Let's load the data into the cache ");
	       //  	loadTopicsDataCache(restTemplate);
	        	System.out.println("Cache Loaded ");
	        	
	        };
	    }


	private void loadTopicsDataCache(RestTemplate restTemplate) {
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=design",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=digital",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=platform",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=cloud",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=ai",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=analytics",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=api",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=microservices",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=container platform",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=devops",List.class);
     //  	restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=fullstack",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=banking",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=insurtech",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=regtech",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=agritech",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=healthcare",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=education",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=cryptocurrency",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=cybersecurity",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=lcnc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=saas",List.class);
      
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=design",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=digital",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=platform",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=cloud",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=ai",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=analytics",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=api",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=microservices",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=container platform",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=devops",List.class);
      //	restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=fullstack",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=banking",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=insurtech",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=regtech",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=agritech",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=healthcare",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=education",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=cryptocurrency",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=cybersecurity",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=lcnc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=saas",List.class);
       
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=design",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=digital",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=platform",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=cloud",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=ai",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=analytics",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=api",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=microservices",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=container platform",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=devops",List.class);
		//restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=fullstack",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=banking",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=insurtech",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=regtech",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=agritech",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=healthcare",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=education",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=cryptocurrency",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=cybersecurity",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=lcnc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=saas",List.class);
       
      
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=designdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=digitaldesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=platformdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=clouddesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=aidesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=analyticsdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=apidesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=microservicesdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=container platformdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=devopsdesc",List.class);
      //	restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=fullstackdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=bankingdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=insurtechdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=regtechdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=agritechdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=healthcaredesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=educationdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=lcncdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=saasdesc",List.class);
		 
		
		
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=deep learning",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=data center",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=virtual worlds",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=bitcoin fundamentals",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=bitcoin company",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=electric vehicles",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=automation",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=autonomous ride",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=delivery drones",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=orbital aerospace",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=3dprinting",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=longread sequencing",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=cancer screening",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=gene therapy",List.class);
		
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=deep learningdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=data centerdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=virtual worldsdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=bitcoin fundamentalsdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=bitcoin companydesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=electric vehiclesdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=automationdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=autonomous ridedesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=delivery dronesdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=orbital aerospacedesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=3dprintingdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=longread sequencingdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=cancer screeningdesc",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/digitaltrends/topicsdata?topic=gene therapydesc",List.class);

		
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=deep learning",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=data center",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=virtual worlds",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=bitcoin fundamentals",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=bitcoin company",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=automation",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=autonomous ride",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=delivery drones",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=orbital aerospace",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=3dprinting",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=longread sequencing",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=cancer screening",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword/person?topicName=gene therapy",List.class);
     
		
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=deep learning",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=data center",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=virtual worlds",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=bitcoin fundamentals",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=bitcoin company",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=automation",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=autonomous ride",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=delivery drones",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=orbital aerospace",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=3dprinting",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=longread sequencing",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=cancer screening",List.class);
		restTemplate.getForObject("http://localhost:8081/v1/topics/wordcloud/keyword?topicName=gene therapy",List.class);
	}
 
	

	}
