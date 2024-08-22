# content-discovery-platform
Content discovery platform delivers personalized content to understand the latest trends around Digital Transformation Business and Technologies.

	Components and Steps involved in data extraction , processing and convert into actionabl insights.
 
	1.Start Zookeeper and Kafka Server :
		bin\zookeeper-server-start.bat config\zookeeper.properties
		bin\kafka-server-start.bat config\server.properties

	2. Start Postgres Server 
 		pg_ctl -D "D:\Program Files\PostgreSQL\12\data" start

	3.Topic Producer :
		java -jar -Xmx256m \appjars\TopicProducer-1.0.jar
	
	4.Topic Consumer and insert batch data into Topics table .
		java -jar -Xmx128m \appjars\TopicRetriever.jar

	5.Provide CSV file input with URL's to mine from the web  .[ e.g 1,http://contentdiscovery.com/krunch ]
 
	6.Provide the CSV as an input to the Web Content Extraction utility .
 
	7. Web Content extractor will fetch the data and insert into raw topic data table.
 
	8.NLP Content extraction program will get the raw data , extract NLP entities ( Organization , Individuals etc ..) , 
          map the data to a common model and insert into tables. 
	  	java -jar -Xmx256m \appjars\ExtractURLContent.jar
	
	9.TS_Vector will be genrated using the query for Topic searches.
	      UPDATE "TopicEntityData"
                    SET  "TSV" = setweight(to_tsvector(coalesce("TransformedText",'')), 'A') || 
	    		         setweight(to_tsvector(coalesce("TopicOgTitle",'')), 'B') ||
	    		         setweight(to_tsvector(coalesce("TopicOgDescription",'')), 'C')
	        where "TSV" is null
	
	
 	10.Start API Gateway Service 
  		java -jar -Xmx128m \apps\krunch-gateway-service-0.1.4-SNAPSHOT.jar

  	11.Start Authentication 
   		java -jar -Xmx128m E:\spring\workspace\krunch-authentication\target\krunch_security_jwt-0.1.6.jar

   	12.Start Topic Search abackend API Services  : 
    		java -jar -Xmx512m \apps\KrunchSearchApp-0.8.6.jar
	
	13. Execute Intelligent reporting app on demand  to generate weekly / daily reports based on your custom algorithm.
 		java -jar -Xmx512m \apps\KrunchContentDiscovery-0.9.0.jar
   
	14.Start Topic Search angular single page application App to query the data based on keywords.
 		ng serve --host 35.176.181.61:4200
