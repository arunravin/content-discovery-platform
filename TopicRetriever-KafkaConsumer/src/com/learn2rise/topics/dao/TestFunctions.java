package com.learn2rise.topics.dao;

import java.util.Date;
import java.sql.Timestamp;

public class TestFunctions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date date=new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		date = timestamp;
		
		System.out.println(date);
	}

}
