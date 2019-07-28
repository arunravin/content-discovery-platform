package com.cdp.topicsstream.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;


public class TweetUtils {
	 
	 public static String removeUrl(String commentstr) {
			 
		 	commentstr = StringUtils.replace(commentstr,  ")", "") ;
		 	commentstr = StringUtils.replace(commentstr,  "(", "") ;
		 	commentstr = StringUtils.replace(commentstr,  "\\", "") ;
		 	commentstr = StringUtils.replace(commentstr,  "?", "") ;
		 	commentstr = StringUtils.replace(commentstr,  "+", "") ;
		 	
		 	commentstr = StringUtils.replace(commentstr,  "RT @", " @") ;
			   
	        String urlPattern = "((https?|ftp|gopher|telnet|file|Unsure|http):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
	        Pattern p = Pattern.compile(urlPattern,Pattern.CASE_INSENSITIVE);
	        Matcher m = p.matcher(commentstr);
	        int i = 0;
	        while (m.find()) {
	            commentstr = commentstr.replaceAll(m.group(i),"").trim();
	            i++;
	        }
	        return commentstr;
	    }
	 
	 public static String removeUserMentionsandHashTags(String tweetString, String identifier)
	    {
		   List<String> lstUserMentions = getUSerMentionsandHashTag(tweetString,identifier);
		  
		   for (String userMention : lstUserMentions) {
			   System.out.println("Inside Loop .. "+ userMention);
			   tweetString = StringUtils.replace(tweetString, userMention, "");
			}
		   
	        return tweetString ;
	    }
	 
	 public static List<String> getUSerMentionsandHashTag(String tweetText, String identifier) {
	        
		 StringTokenizer tokenizer = new StringTokenizer(tweetText);
	        List<String> userMentionsandHashTags = new ArrayList<String>();
	        
	        while (tokenizer.hasMoreTokens()) {
	            String token = tokenizer.nextToken();
	            if (token.startsWith(identifier) ) {
	            	userMentionsandHashTags.add(token);
	            }
	        }
	        
	        return userMentionsandHashTags;
	    }
	 
	 
	 
	 
	 public static void main(String ar[]) throws Exception{
		 
		 String strTweet =  "RT @delizalde: 7 Ways to Get a Product Management Job when You Lack Industry Experience https://t.co/rxb2gQdSQT #IoT #Prodmgmt #IIoT #Tech…";
		 String cleanTweet = TweetUtils.removeUrl(strTweet);
		 String twWithoutUSerMentions = TweetUtils.removeUserMentionsandHashTags(cleanTweet,"@");
		 String twWithoutHashTags = TweetUtils.removeUserMentionsandHashTags(twWithoutUSerMentions,"#");
		 
		 System.out.println(twWithoutHashTags);
		 
	 }
	
}