# content-discovery-platform
Content discovery platform delivers personalized content to understand the latest trends around Digital Transformation Business and Technologies.

1.Topic Producer :
java -jar -Xmx256m E:\learnrise\twitterStreamingSparkKafkaDemo-master\producer\target\TopicProducer-1.0.jar

2.Topic Consumer and insert batch data into Topics table .
java -jar -Xmx128m E:\learnrise\appjars\TopicRetriever.jar


3.Input CSV file generation Query . 
4.Generated CSV will be fed into the Web Content Extraction program .
5. Web Content extractor will fetch the data and insert into raw topic data table
6.NLP Content extraction program will get the raw data , extract NLP entities ( Organization , Individuals etc ..) , map the data to a common model and insert into tables.
java -jar -Xmx256m E:\learnrise\appjars\ExtractURLContent.jar

7).TS_Vector will be genrated using the query for Topic searches.
      UPDATE "TopicEntityData" SET
    "TSV" = setweight(to_tsvector(coalesce("TransformedText",'')), 'A') || 
    		setweight(to_tsvector(coalesce("TopicOgTitle",'')), 'B') ||
    		setweight(to_tsvector(coalesce("TopicOgDescription",'')), 'C')
    where "TSV" is null


8.Start Topic Search App to query the data based on keywords.

9. Us Intelligent reporting app to generate weekly / daily reports based on your custom algorithm.

COPY (Select count("Id") as countno,"TransformedText" ,"TopicUrl" 
  from "Topics"
  	where
		"CreatedAt" between TO_TIMESTAMP('13-01-2023 18:45:00' ,
		  'dd-mm-yyyy hh24:mi:ss') AND CURRENT_TIMESTAMP
	  and lower("TopicUrl") not like '%eut.io%' and lower("TopicUrl") not like '%dynamic.%'
	  and lower("TopicUrl") not like '%launchmy%'
	  and lower("TopicUrl") not like '%twinybot%'
	  and lower("TopicUrl") not like '%onelink%'
	  and lower("TopicUrl") not like '%coupon%'
	  and lower("TopicUrl") not like  '%twitter.com%'
	  and lower("TopicUrl") not like  '%web3shot%'
	  and lower("TopicUrl") not like  '%vergecurrency%'
	  and lower("TopicUrl") not like '%wpsec.com%'
	  and lower("TopicUrl") not like  '%onlineclases%'
	  and lower("TopicUrl") not like  '%wpsec.com%'
	  and lower("TopicUrl") not like  '%paper.li%'
	  and lower("TopicUrl") not like  '%fiverr.com%'
	  and lower("TopicUrl") not like  '%aws.im%'
	  and lower("TopicUrl") not like  '%bitsail%'
	  and lower("TopicUrl") not like  '%kale%'
	  and lower("TopicUrl") not like  '%amzn.to%'
	  and lower("TopicUrl") not like  '%wembassy%'
	  and lower("TopicUrl") not like  '%trib%'
	  and lower("TopicUrl") not like  '%skillbuilder%'
	  and lower("TopicUrl") not like  '%voicebot%'
	  and lower("TopicUrl") not like  '%wembassy%'
	  and lower("TopicUrl") not like  '%pirple%'
	  and lower("TopicUrl") not like  '%dailymail%'
	  and lower("TopicUrl") not like  '%newsupdate%'
	  and lower("TopicUrl") not like  '%real-digital.d%'
	  and lower("TopicUrl") not like  '%job%'
	  and lower("TopicUrl") not like  '%5stocks%'
	  and lower("TopicUrl") not like  '%discord.%'
	  and lower("TopicUrl") not like  '%opensea.%'
	  and lower("TopicUrl") not like  '%seademons.%'
	  and lower("TopicUrl") not like  '%5stocks%'
	  and lower("TopicUrl") not like  '%adastat%'
	  and lower("TopicUrl") not like  '%galxe.com%'
	  and lower("TopicUrl") not like  '%pxlmage.com%'
	  and lower("TopicUrl") not like  '%pin.it%'
	  and lower("TopicUrl") not like  '%joepegs%'
	  and lower("TopicUrl") not like  '%snowtrace%'
  	   	group by "TopicUrl","TransformedText" 
			order by count("Id") desc
			) to  '/Users/maliniarun/Downloads/topics.csv' DELIMITER ',' CSV HEADER;

select  "TopicOgUrl","CreatedAt","UpdatedAt","OrganizationEntities" , 
"PersonEntities"  from "TopicEntityData" order by "CreatedAt" desc limit 100

select  "TopicOgUrl", "TopicOgUrlContent" , "TopicOutGoingLinksUrlSet" 
	from "TopicEntityData"
					where "TopicOgUrlContent" <> '' 
					and length("OrganizationEntities") <=0


Postgresql - super user : root
psql -d postgres -U root
Start Postgres Server 
pg_ctl -D "D:\Program Files\PostgreSQL\12\data" start
pg_ctl -D "D:\Program Files\PostgreSQL\12\data" stop
H1ckMe@1101

ng serve --host 35.176.181.61:4200

Start Zookeeper and Kafka Server :
C:\kafka\kafka_2.12-2.8.0\bin\windows\zookeeper-server-start.bat C:\kafka\kafka_2.12-2.8.0\config\zookeeper.properties
C:\kafka\kafka_2.12-2.8.0\bin\windows\kafka-server-start.bat C:\kafka\kafka_2.12-2.8.0\config\server.properties

bin\zookeeper-server-start.bat config\zookeeper.properties

bin\kafka-se rver-start.bat config\server.properties

./bin/kafka-server-start.sh config/server.properties

Create Topic :
C:\kafka\kafka_2.12-2.8.0\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic tweets
D:\kafka\kafka_2.12-2.8.0\bin\windows\kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic trendingtopics

View Messages in Topic
C:\kafka\kafka_2.12-2.8.0\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic trendingtopics --from-beginning

Delete Kakfa Logs in case of Cluster ID not found or Consumer Offset issue :
D:\tmp\logs\kafka-log

Start Topic Producer:
java -jar -Xmx256m E:\learnrise\twitterStreamingSparkKafkaDemo-master\producer\target\TopicProducer-1.0.jar
Start Topic Consumer :
java -jar -Xmx128m E:\learnrise\appjars\TopicRetriever.jar
Start Eureka Service Discovery
java -jar -Xmx128m E:\spring\workspace\krunch-service-discovery\target\krunch-service-discovery-1.0.0-SNAPSHOT.jar
Start API Gateway Service
java -jar -Xmx128m E:\spring\workspace\krunch-gateway-service\target\krunch-gateway-service-0.1.4-SNAPSHOT.jar
Start Topic Search App :
java -jar -Xmx512m E:\spring\workspace\krunch-topics-search\target\KrunchSearchApp-0.8.6.jar
java -jar -Xmx512m E:\spring\workspace\krunch-api-contentdiscovery\target\KrunchContentDiscovery-0.9.0.jar
Start Realtime APP :
java -jar E:\spring\workspace\TopicsRealTime\target\reactive-kafka-websocket-0.0.1-SNAPSHOT.jar
Start Authentication
java -jar -Xmx128m E:\spring\workspace\krunch-authentication\target\krunch_security_jwt-0.1.6.jar
Extract URL COntent
java -jar -Xmx256m E:\learnrise\appjars\ExtractURLContent.jar
Topic Ranking Algojava -jar -Xmx256m E:\learnrise\twitterStreamingSparkKafkaDemo-master\producer\target\TopicProducer-1.0.jar

java -jar E:\spring\workspace\krunch-api-intelligentreports\target\TopicRankingAlgo-1.7.jar

create table YouTube_Videos
as 
select count("Id") as "Count" ,"TransformedText" ,"TopicUrl" 
  from "Topics_Bak" where 
	   lower("TopicUrl") like '%youtube%'
	   	group by "TopicUrl","TransformedText" 
		union
select count("Id")  as "Count","TransformedText" ,"TopicUrl" 
  from "Topics" where 
	   lower("TopicUrl") like '%youtube%'
	   	group by "TopicUrl","TransformedText" 
			
select count("Id") ,"TransformedText" ,"TopicUrl" 
  from "Topics"
    where "CreatedAt" between TO_TIMESTAMP('11-12-2021 18:08:00 PM' ,
		   'dd-mm-yyyy hh24:mi:ss') AND CURRENT_TIMESTAMP
	  and lower("TopicUrl") not like '%twinybot%'
	  and lower("TopicUrl") not like '%onelink%'
	  and lower("TopicUrl") not like '%coupon%'
	  and lower("TopicUrl") not like  '%twitter.com%'
	  and lower("TopicUrl") not like  '%vergecurrency%'
	  and lower("TopicUrl") not like '%wpsec.com%'
	  and lower("TopicUrl") not like  '%onlineclases%'
	  and lower("TopicUrl") not like  '%wpsec.com%'
	  and lower("TopicUrl") not like  '%paper.li%'
	  and lower("TopicUrl") not like  '%fiverr.com%'
	  and lower("TopicUrl") not like  '%aws.im%'
	  and lower("TopicUrl") not like  '%bitsail%'
	  and lower("TopicUrl") not like  '%kale%'
	  and lower("TopicUrl") not like  '%amzn.to%'
	  and lower("TopicUrl") not like  '%wembassy%'
	  and lower("TopicUrl") not like  '%trib%'
	  and lower("TopicUrl") not like  '%voicebot%'
	  and lower("TopicUrl") not like  '%wembassy%'
	  and lower("TopicUrl") not like  '%pirple%'
	  and lower("TopicUrl") not like  '%dailymail%'
	  and lower("TopicUrl") not like  '%newsupdate%'
	  and lower("TopicUrl") not like  '%real-digital.d%'
	  and lower("TopicUrl") not like  '%job%'
	  and lower("TopicUrl") not like  '%5stocks%'
	  and lower("TopicUrl") not like  '%discord.%'
	  and lower("TopicUrl") not like  '%opensea.%'
	   and lower("TopicUrl") not like  '%seademons.%'
	  and lower("TopicUrl") not like  '%5stocks%'
	  and lower("TopicUrl") not like  '%adastat%'
   --   and lower("TransformedText") like '%saas%'
	--  or lower("TopicUrl") like '%saas%'
	  	group by "TopicUrl","TransformedText" 
			order by count("Id") desc


COPY "SELECT OrganizationEntities from TrendsReporting" TO 'E:/data/entities.csv' DELIMITER ',' CSV HEADER;

COPY (SELECT distinct  "PersonEntities","TopicUrlCount" from "TopicContentData" where "PersonEntities"  <>'' order by "TopicUrlCount" desc) TO 'E:/data/personentities.csv' DELIMITER ',' CSV HEADER;

COPY (SELECT  distinct "OrganizationEntities","TopicUrlCount" from "TopicContentData" where "OrganizationEntities"  <>'' order by "TopicUrlCount" desc) TO 'E:/data/organizationentities.csv' DELIMITER ',' CSV HEADER;

COPY (SELECT distinct "CountryEntities","TopicUrlCount" from "TopicContentData" where "CountryEntities"  <>'' order by "TopicUrlCount" desc) TO 'E:/data/countryentities.csv' DELIMITER ',' CSV HEADER;

COPY (SELECT distinct "CityEntities","TopicUrlCount" from "TopicContentData" where "CityEntities"  <>'' order by "TopicUrlCount" desc) TO 'E:/data/cityentities.csv' DELIMITER ',' CSV HEADER;

Replace Space associated with | symbol.


delete from "TrendingEntities" where lower("EntityName") 
in ('asia','valley','bay','metro','he','she','him','his','her','inc.',
	'nlp','gpu','cto','vpn','csv',5292524400430117, 266,Crore053080$)
	 
SELECT to_json(r)
FROM (
    SELECT
        json_agg(t.a) AS a,
        json_agg(t.b) AS b
    FROM t
) r

SELECT alias, description, token FROM ts_debug('http://example.com/stuff/index.html');

CREATE EXTENSION pg_trgm;
			
CREATE INDEX trgm_idx_topics_transformedtext ON "Topics"
USING gin ("TransformedText" gin_trgm_ops);
			
CREATE INDEX trgm_idx_topics_topicurl ON "Topics"
USING gin ("TopicUrl" gin_trgm_ops);

CREATE INDEX trgm_idx_topiccontentdata_topicogdescription ON "TopicContentData"
USING gin (lower("TopicOgDescription") gin_trgm_ops);

CREATE INDEX trgm_idx_topiccontentdata_topicogurlcontent ON "TopicContentData"
USING gin (lower("TopicOgUrlContent") gin_trgm_ops);

CREATE INDEX trgm_idx_topiccontentdata_topicogtitle ON "TopicContentData"
USING gin (lower("TopicOgTitle") gin_trgm_ops);

CREATE INDEX trgm_idx_topiccontentdata_topicogurl ON "TopicContentData"
USING gin (lower("TopicOgUrl") gin_trgm_ops);

CREATE INDEX trgm_idx_topiccontentdata_topictransformedtext ON "TopicContentData"
USING gin (lower("TransformedText") gin_trgm_ops);

ALTER TABLE "TopicEntityData" ADD COLUMN "TSV" tsvector;

CREATE INDEX tsv_idx ON "TopicEntityData" USING gin("TSV");

ALTER TABLE "TopicEntityData" ADD COLUMN "TSV_FULL" tsvector;

CREATE INDEX tsv_full_idx ON "TopicEntityData" USING gin("TSV_FULL");

CREATE INDEX idx_fts_doc_vec ON "TopicEntityData" USING gin("TSV_FULL");

CREATE INDEX idx_tsv_doc_vec ON "TopicEntityData" USING gin("TSV");

UPDATE "TopicEntityData" SET
"TSV_FULL" = setweight(to_tsvector(coalesce("TopicOgTitle",'')), 'A') ||
		setweight(to_tsvector(coalesce("TopicOgUrlContent",'')), 'B')
where "TSV_FULL" is null

UPDATE "TopicEntityData" SET
"TSV" = setweight(to_tsvector(coalesce("TransformedText",'')), 'A') || 
		setweight(to_tsvector(coalesce("TopicOgTitle",'')), 'B') ||
		setweight(to_tsvector(coalesce("TopicOgDescription",'')), 'C')
where "TSV" is null
		
UPDATE "TopicEntityData" SET
"TSV_FULL" = setweight(to_tsvector(coalesce("TopicOgTitle",'')), 'A') || 
		setweight(to_tsvector(coalesce("TopicOgDescription",'')), 'B') ||
		setweight(to_tsvector(coalesce("TopicOgUrlContent",'')), 'C')
where "TSV_FULL" is null
	
		
SELECT  "TopicOgUrl", "TopicOgTitle" ,"TopicOgDescription", "TopicUrlCount" ,
"TopicOgImage" ,"OrganizationEntities" , "PersonEntities" ,"TitleEntities" , 
"CountryEntities", "CityEntities" , "DurationEntities", "DateEntities",
"MoneyEntities" , ts_rank_cd(t1."TSV", plainto_tsquery('aws')) 
FROM (  SELECT "TopicOgUrl",  "TopicOgTitle" ,"TopicOgDescription", "TopicUrlCount" ,
"TopicOgImage" ,"OrganizationEntities" , "PersonEntities" ,"TitleEntities" , 
"CountryEntities", "CityEntities" , "DurationEntities", "DateEntities",
"MoneyEntities", "TSV"
	  FROM "TopicEntityData", plainto_tsquery('aws') AS q
  WHERE ("TSV" @@ q) 
) AS t1 where  "TopicUrlCount" >= 5 and 
 lower("TopicOgTitle") not like '%coupon%' and lower("TopicOgTitle") not like '%course%'  
 and lower("TopicOgTitle") not like '%certifi%'
 ORDER BY  ts_rank_cd(t1."TSV", plainto_tsquery('aws')) desc
 
 
 D:\Program Files\PostgreSQL\12\bin\pg_dump.exe --file "C:\\Users\\arunr\\OneDrive\\DOCUME~1\\RISE2E~1" --host "localhost" --port "5432" --username "postgres" --no-password --verbose --format=c --blobs "rise2earn"

Google :
Client ID : 1057299260221-chm180t098k456t95ataksdojimu3ld6.apps.googleusercontent.com
N1Me5zwrriU7ghaorVJZffxZ
Amazon 
Client ID:amzn1.application-oa2-client.eb72a9559ad44e3989d3c1ea4f6bee55
Client Secret:8ae4e4835ac4b84f419cd6c24960eece578ce6723822edc599e911da6c2f2c6d
Microsoft :
Client Id : 36faf6d0-8d85-4b49-a1a7-2e23c960b1d1
Facebook
App Id: 755909052006862
AppSecret:04b92d2c5cef4f0104b72c735df9aec5

https://rsenthilk.signin.aws.amazon.com/console




Queries :

Top URL Query :

select 
count("Id") , "TopicUrl" from "Topics"
	group by "TopicUrl"
		order by count("Id") desc
		
select count("Id") ,"TransformedText" ,"TopicUrl" 
  from "Topics"
	group by "TopicUrl","TransformedText"
		order by count("Id") desc

select count("Id") ,"TransformedText" ,"TopicUrl" 
  from "Topics"
    where "CreatedAt" between TO_TIMESTAMP('16/09/2020 23:00:00 AM',
		   'dd-mm-yyyy hh12:mi:ss') AND CURRENT_TIMESTAMP
	group by "TopicUrl","TransformedText"
		order by count("Id") desc
		
select count("Id") ,"TransformedText" ,"TopicUrl" 
  from "Topics"
    where "CreatedAt" between CURRENT_TIMESTAMP - (interval '60s') * 60
		AND CURRENT_TIMESTAMP
			group by "TopicUrl","TransformedText"
				order by count("Id") desc
				2020-09-19 23:59:05.724

select * from "TopicEntityData" where "CreatedAt"
between TO_TIMESTAMP('24/01/2021 01:00:00 AM',
		   'dd-mm-yyyy hh12:mi:ss') AND CURRENT_TIMESTAMP
 order by "CreatedAt" ASC limit 5


select "Keyword" , count("Keyword") as count
	from "User_Topics_Search_Keywords" 
		group by "Keyword" 
			order by count desc


npm i @angular/animations -S

netstat -aon | findstr "6379"
netstat -aon | findstr "8080"
netstat -aon | findstr "5432"
35.201.124.9:443
	taskkill /F /PID 12564

start nginx
tasklist /fi "imagename eq nginx.exe"
nginx s stop
nginx s reload

INSERT INTO public."User_Topics_Search_Keywords"(
	"UserName", "Keyword", "CreatedAt", "SearchType",  "is_Valid")
	VALUES ('arunravin@gmail.com', 'Machine Learning', '2021-02-26 08:57:19.005', 'GS',  'Y');

ng serve --host 0.0.0.0 --public-host epicsite.test

{
    "Version": "2012-10-17",
    "Statement": [
        {
            "Sid": "Allow Public Access to All Objects",
            "Effect": "Allow",
            "Principal": "*",
            "Action": "s3:GetObject",
            "Resource": "YOUR_BUCKET_ARN/*"
        }
    ]
}






-- Table: public.TopicData

-- DROP TABLE public."TopicData";
-- Table: public.TopicData

-- DROP TABLE public."TopicData";
-- Table: public.TopicData

-- DROP TABLE public."TopicData";

CREATE TABLE public."TopicData"
(
    "TopicOgUrl" text COLLATE pg_catalog."default" NOT NULL,
	"TopicOgUrlContent" text COLLATE pg_catalog."default" NOT NULL,
    "TopicOgTitle" text COLLATE pg_catalog."default" NOT NULL,
    "TopicOgDescription" text COLLATE pg_catalog."default",
    "TopicOgImage" text COLLATE pg_catalog."default",
    "TopicUrlCount" smallint,
    "TransformedText" text COLLATE pg_catalog."default",
    "CreatedAt" date NOT NULL,
    "OrganizationEntities" text COLLATE pg_catalog."default",
    "PersonEntities" text COLLATE pg_catalog."default",
    "LocationEntities" text COLLATE pg_catalog."default",
    "TitleEntities" text COLLATE pg_catalog."default",
    "MoneyEntities" text COLLATE pg_catalog."default",
    "NationalityEntities" text COLLATE pg_catalog."default",
    "CountryEntities" text COLLATE pg_catalog."default",
    "CityEntities" text COLLATE pg_catalog."default",
    "TopicOutGoingLinksCount" smallint,
    "TopicOutGoingLinksUrlSet" text COLLATE pg_catalog."default",
    "TSV_FULL" tsvector ,
    CONSTRAINT "TopicData_pkey" PRIMARY KEY ("TopicOgUrl", "CreatedAt")
) PARTITION BY RANGE ("CreatedAt") 

TABLESPACE topic_data;

ALTER TABLE public."TopicData"
    OWNER to postgres;
	

CREATE INDEX tsv_full_par_idx ON "TopicData" USING gin("TSV_FULL");

CREATE INDEX trgm_idx_topicdata_topicogtitle ON "TopicData"
USING gin (lower("TopicOgTitle") gin_trgm_ops);

CREATE INDEX trgm_idx_topicdata_transformedtext ON "TopicData"
USING gin (lower("TransformedText") gin_trgm_ops);

-- Partitions SQL

CREATE TABLE public."TopicData_2020_07" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2020-07-01') TO ('2020-08-01');

CREATE TABLE public."TopicData_2020_08" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2020-08-01') TO ('2020-09-01');

CREATE TABLE public."TopicData_2020_09" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2020-09-01') TO ('2020-10-01');

CREATE TABLE public."TopicData_2020_10" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2020-10-01') TO ('2020-11-01');

CREATE TABLE public."TopicData_2020_11" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2020-11-01') TO ('2020-12-01');

CREATE TABLE public."TopicData_2020_12" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2020-12-01') TO ('2021-01-01');

CREATE TABLE public."TopicData_2021_01" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2021-01-01') TO ('2021-02-01');
	

CREATE TABLE public."TopicData_2021_02" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2021-02-01') TO ('2021-03-01');

CREATE TABLE public."TopicData_2021_03" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2021-03-01') TO ('2021-04-01');

CREATE TABLE public."TopicData_2021_04" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2021-04-01') TO ('2021-05-01');

CREATE TABLE public."TopicData_2021_05" PARTITION OF public."TopicData"
    FOR VALUES FROM ('2021-05-01') TO ('2021-06-01');
	
CREATE TABLE public."TopicData_2021_06" PARTITION OF public."TopicData"
FOR VALUES FROM ('2021-06-01') TO ('2021-06-09');

CREATE TABLE public."TopicData_CURRENT" PARTITION OF public."TopicData"
FOR VALUES FROM ('2021-06-01') TO ('2021-06-14');


Drop table "TopicData_2021_06"

insert into "TopicData" (
SELECT "TopicOgUrl", "TopicOgUrlContent", "TopicOgTitle", "TopicOgDescription", 
"TopicOgImage", "TopicUrlCount", "TransformedText", "CreatedAt", "OrganizationEntities",
"PersonEntities", "LocationEntities", "TitleEntities", "MoneyEntities", "NationalityEntities",
"CountryEntities", "CityEntities", "TopicOutGoingLinksCount", "TopicOutGoingLinksUrlSet", "TSV_FULL"
	FROM public."TopicEntityData" where "CreatedAt" between TO_TIMESTAMP('05/06/2021 01:00:01 AM',
		   'dd-mm-yyyy hh12:mi:ss') AND CURRENT_TIMESTAMP );


http://localhost:8084/v1/intelligentreports/topic?topicname=cloudnative&timeinterval=14

http://localhost:8084/v1/intelligentreports/topic?topicname=banking&timeinterval=8
http://localhost:8084/v1/intelligentreports/topic?topicname=embeddedbusiness&timeinterval=8
http://localhost:8084/v1/intelligentreports/topic?topicname=veturecapital&timeinterval=8
http://localhost:8084/v1/intelligentreports/topic?topicname=saas&timeinterval=8
http://localhost:8084/v1/intelligentreports/topic?topicname=profoundai&timeinterval=8
http://localhost:8084/v1/intelligentreports/topic?topicname=lending&timeinterval=8
http://localhost:8084/v1/intelligentreports/topic?topicname=nft&timeinterval=8

http://localhost:8084/v1/intelligentreports/topic?topicname=microservices&timeinterval=8

http://localhost:8084/v1/intelligentreports/topic?topicname=platform&timeinterval=8
http://localhost:8084/v1/intelligentreports/topic?topicname=analytics&timeinterval=8
http://localhost:8084/v1/intelligentreports/topic?topicname=cloud&timeinterval=8
http://localhost:8084/v1/intelligentreports/topic?topicname=dataanalytics&timeinterval=8

http://localhost:8084/v1/intelligentreports/topic?topicname=design&timeinterval=8


http://localhost:8084/v1/intelligentreports/topic?topicname=whitespaces&timeinterval=8


docker build -t arunravin8/krunchsearchapp .
docker run -p 8081:8081 arunravin8/krunchsearchapp
docker build -t arunravin8/krunchauthapp .
docker run -p 9991:9991 arunravin8/krunchsearchapp

helm install krunch-chart krunchapp/ --values krunchapp/values.yaml

kubectl delete deployment krunch-chart
kubectl get rs --all-namespaces
docker pull arunravin8/krunchsearchapp:latest
kubectl create secret docker-registry <name> --docker-server=DOCKER_REGISTRY_SERVER --docker-username=DOCKER_USER --docker-password=DOCKER_PASSWORD --docker-email=DOCKER_EMAIL

{
    "topicName" : "fintech"
    }

{
    "topicName" : "fintech",
    "topicContainsFilter" : "payment",
    "recencyDays" : "30",
    "totalOutPutRecords" : "100",
    "minimumRelevancyScore" : ".75",
    "topicRating" : "3",
    "topicMinPopularity" : "5",
    "associatedOrg" : "master",
    "associatedPerson" : "michael"
}

  {
        "ogImage": "https://startup.info/wp-content/uploads/2021/06/Fintech-Apps.jpg",
        "ogTitle": "A Complete Guide on How to Start a Fintech Startup in 2021",
        "ogDescription": "Financial Technology or Fintech is a popular term for it has been in use for a while. The digital transformation technology has improved the way the financial",
        "ogUrl": "https://startup.info/a-complete-guide-on-how-to-start-a-fintech-startup-in-2021/",
        "ogUrlContent": "",
        "popularity": 29,
        "relevancy": 10.2,
        "cwgscore": 28.2,
        "entities": null,
        "organizationEntities": "Digital Lending Digital|Consumer Finance Users|Fintech Startup|Oscar Health|CFTC|Machine Learning|Insuretech Insuretech|Blockchain Blockchain|Lending Club|KYC|KYB|Financial Technology|Federal Deposit Insurance Corporation|Microsoft|Consumer Financial Protection Bureau|General Data Protection Regulation|AML|Major Technology Trends|Google|PayPal|Fintech|Digital Investment Today|Digital Currency Exchange|OCC|Payment Card Industry Data Security Standard|Apple|FDIC|Robinhood|Commodity Futures Trading Commission",
        "personEntities": "Xero|Robinhood|Purity Muriuki|Adyen",
        "titleEntities": "",
        "moneyEntities": "",
        "createdAt": "2021-06-03",
        "timeInterval": "> 2 Months",
        "trendingStatus": "fa-sm",
        "rating": 4,
        "recency": 64
    }
	
	
	http://localhost:8081/api/v1/topics/topicentitysearch/cloudnative?topicName=cloudnative
{
    "topicName": "fintech",
    "totalOutPutRecords" : "10",
    "recencyDays" : "5",
    "minimumRelevancyScore" : "1",
    "orderBy" : "",

}
