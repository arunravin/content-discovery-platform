package com.cdp.topicsstream;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.StringJoiner;

import org.apache.commons.lang3.StringUtils;

import com.cdp.topicsstream.utils.TweetUtils;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import twitter4j.HashtagEntity;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.URLEntity;
import twitter4j.conf.ConfigurationBuilder;
import twitter4j.json.DataObjectFactory;


public class DigitalTweets {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

	static  final Properties appConfigProperties  =  initialseApplicationConfig();
	
	public static void main(String[] args) throws Exception {

	    String[] topicsArray = appConfigProperties.getProperty("topicstofilterarray").split(",");
	    
	    System.out.println("Topics to Stream : "+Arrays.toString(topicsArray));
	 
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey(appConfigProperties.getProperty("consumerkey"));
        cb.setOAuthConsumerSecret(appConfigProperties.getProperty("consumersecret"));
        cb.setOAuthAccessToken(appConfigProperties.getProperty("accesstoken"));
        cb.setOAuthAccessTokenSecret(appConfigProperties.getProperty("accesstokensecret"));
        cb.setJSONStoreEnabled(true);

        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();

        final DBCollection digitialTweetCol = initialiseMongoDB();
	    final List<DBObject> lstDigitalTweets = new ArrayList<DBObject>();
	    
    //    final String topicName = "realtimetrends";
    	//	Properties props = KafkaConnection.getProperties();
    	//	final Producer<String, String> producer = new KafkaProducer <String, String>(props);

		/*	
		twitterStream.setOA
		uthConsumer(_consumerKey, _consumerSecret);
		AccessToken token = new AccessToken(_accessToken, _accessTokenSecret);
		twitterStream.setOAuthAccessToken(token);
         */
	
        /**ID
         * user
         * tweettext
         * topictext
         * retweetcount
         * retweetfavouritecount
         * userlocation
         * userfollowerscount
         * userfriendscount
         * userlistcount
         * hashTags
         * expandedurl
         * 
         */
 

		StatusListener listener = new StatusListener() {
			public void onStatus(Status status) {
				
            String tweet = DataObjectFactory.getRawJSON(status);
            
            DBObject newDigiTweets = new BasicDBObject();
            
            
            newDigiTweets.put("ID", status.getId()); // Topic ID 
            newDigiTweets.put("user", status.getUser().getScreenName()); //User Name 
            if (status.getRetweetedStatus().getText() != null) {
            		 newDigiTweets.put("tweettext", status.getRetweetedStatus().getText());
            		 newDigiTweets.put("topictext",transTweetText(status.getRetweetedStatus().getText()) );
             } else {
            		newDigiTweets.put("tweettext", status.getText()); // Raw Tweet Textx
            		newDigiTweets.put("topictext",transTweetText(status.getText()));
             }
            newDigiTweets.put("retweetcount", status.getRetweetedStatus().getRetweetCount() ); 
            newDigiTweets.put("createdat", status.getCreatedAt());
            newDigiTweets.put("retweetfavouritecount", status.getRetweetedStatus().getFavoriteCount());
            newDigiTweets.put("userlocation", status.getUser().getLocation()); // Location
            newDigiTweets.put("userfollowerscount", status.getUser().getFollowersCount());
            newDigiTweets.put("userfriendscount", status.getUser().getFriendsCount());
            newDigiTweets.put("userlistcount", status.getUser().getListedCount());
            
            
            URLEntity[] urlEntities = status.getURLEntities();
            HashtagEntity[]  hashTagEntities = status.getHashtagEntities();
           
            int hashTagSize = hashTagEntities.length;
            
            StringJoiner sj = new StringJoiner("|");
            for (int i=0; i<hashTagSize;  i++) {
                    	if(hashTagEntities[i]!=null) {
		            		   sj.add(hashTagEntities[i].getText());
		            	}
            }
            
            
         //   System.out.println(strHashTag);
            
            newDigiTweets.put("hashTags", sj.toString());
            newDigiTweets.put("expandedurl",  urlEntities[0].getExpandedURL() );
          //  digitialTweetCol.insert(newDigiTweets);
         
            
            //To Stop : Bitcointalk: , AdultNetwork , FreeTrial , HOSTKEY ,DirectIM , Scanner , Node: , Discounts , Udemyfree , Airdrops
            //				, Airdropalert, Abuse , SCAMMERS , EthereumClassic
            
            lstDigitalTweets.add(newDigiTweets) ;
            	
    //        System.out.println( newDigiTweets.get("topictext")  + "              "+ 
    //        							sj.toString()  + "              "+ newDigiTweets.get("expandedurl"));
            
            if ( lstDigitalTweets.size() >250) {
             		digitialTweetCol.insert(lstDigitalTweets);
             		System.out.println("250 Records inserted ..." );
             		lstDigitalTweets.clear();
            }
         
           // DBObject doc = (DBObject)JSON.parse(tweet);
           // digitialTweetCol.insert(doc);
	
           //producer.send(new ProducerRecord<String, String>(topicName, jsonString));
    	    
            //  String strTweet = status.getCreatedAt() +"  :  " + status.getText() + "\n";
            //   System.out.println(strTweet);
				
			
			}

			public void onException(Exception arg0) {

			}

			public void onDeletionNotice(StatusDeletionNotice arg0) {

			}

			public void onScrubGeo(long arg0, long arg1) {

			}

			public void onStallWarning(StallWarning arg0) {

			}

			public void onTrackLimitationNotice(int arg0) {

			}

		};

		twitterStream.addListener(listener);
		//query1.track("")
		twitterStream.filter( topicsArray);

	}

	/**
	 * @return
	 * @throws UnknownHostException
	 */
	public static DBCollection initialiseMongoDB() throws UnknownHostException {
		Mongo twitterMongo = new Mongo(appConfigProperties.getProperty("db.url"));
	    DB twitterdb = twitterMongo.getDB(appConfigProperties.getProperty("db.name"));
	       
	    final DBCollection digitialTweetCol = twitterdb.getCollection(appConfigProperties.getProperty("db.collectioname"));
		return digitialTweetCol;
	}
	
	
	public static String transTweetText(String tweetText) {
		
		String strTopicText = TweetUtils.removeUrl(tweetText);
	    strTopicText = TweetUtils.removeUserMentionsandHashTags(strTopicText,"@");
	    strTopicText = TweetUtils.removeUserMentionsandHashTags(strTopicText,"#");
		
		//System.out.println("*&&*&&**&&*&*&*&*"+strTopicText);
		
		return strTopicText;
		
	}

	// During Phase 2 needs to be moved to Spring Cloud Config as part of Central Configuration .
	public static Properties initialseApplicationConfig() {
		
		Properties prop = new Properties();
		
		//try (InputStream input = new FileInputStream("/Users/arunr/Documents/cdp/appconfig.properties")) {

		try (InputStream input = new FileInputStream("src/main/resources/appconfig.properties")) {
            // load a properties file
            prop.load(input);

            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return null;
		
		
		
	}
	

}
