package com.learn2rise.contentextraction.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;


import com.learn2rise.contentextraction.datasource.*;

public class TopicsEntityDataMigration {

	public static void main(String args[]) throws Exception {

		getTopicURLandContent();

	}

	private static Map<String, String> getTopicURLandContent() throws SQLException {
		
		String INSERT_TOPIC_ENTITY = "INSERT INTO public.\"TopicEntityData\"(\"TopicOgDescription\", \"TopicOgTitle\", \"TopicOgImage\", "
				+ "\"TopicOgUrlContent\", \"Keywords\", \"TopicUrlCount\", \"TransformedText\", \"TopicOgLocale\", \"CreatedAt\", "
				+ "\"ArticleAuthor\", \"ArticlePublishedTime\", \"TopicOgUrl\", \"OrganizationEntities\", \"PersonEntities\","
				+ " \"LocationEntities\", \"MiscEntities\", \"TitleEntities\", \"DateEntities\", \"DurationEntities\", \"MoneyEntities\","
				+ " \"HandleEntities\", \"NumberEntities\", \"NationalityEntities\", \"CountryEntities\", \"CityEntities\", \"entitiesUpdated\","
				+ " \"isContentExtracted\", \"URLEntities\", \"StateorProvinceEntities\", \"isEntityExtracted\", \"TopicSourceUrl\", "
				+ " \"Topic1\") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		Statement stmt = null;
		Connection conn = DataSource.getConnection();
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from \"TopicContentData\"\r\n"
				+ "where \"TopicOgUrlContent\" <> '' and \"OrganizationEntities\" is not null ");
		System.out.println("After executing resultset ");

		PreparedStatement stmt1 = conn.prepareStatement(INSERT_TOPIC_ENTITY);  
		
		while (rs.next()) {
			try {
				
				stmt1.setString(1, rs.getString(1));
				stmt1.setString(2, rs.getString(2));
				stmt1.setString(3, rs.getString(3));
				stmt1.setString(4, rs.getString(4));
				stmt1.setString(5, rs.getString(5));
				stmt1.setInt(6, rs.getInt(6));
				stmt1.setString(7, rs.getString(7));
				stmt1.setString(8, rs.getString(8));
				stmt1.setTimestamp(9, rs.getTimestamp(9));
				stmt1.setString(10, rs.getString(10));
				stmt1.setString(11, rs.getString(11));
				stmt1.setString(12, rs.getString(12));
				stmt1.setString(13, rs.getString(13));
				stmt1.setString(14, rs.getString(14));
				stmt1.setString(15, rs.getString(15));
				stmt1.setString(16, rs.getString(16));
				stmt1.setString(17, rs.getString(17));
				stmt1.setString(18, rs.getString(18));
				stmt1.setString(19, rs.getString(19));
				stmt1.setString(20, rs.getString(20));
				stmt1.setString(21, rs.getString(21));
				stmt1.setString(22, rs.getString(22));
				stmt1.setString(23, rs.getString(23));
				stmt1.setString(24, rs.getString(24));
				stmt1.setString(25, rs.getString(25));
				stmt1.setString(26, rs.getString(26));
				stmt1.setString(27, rs.getString(27));
				stmt1.setString(28, rs.getString(28));
				stmt1.setString(29, rs.getString(29));
				stmt1.setString(30, rs.getString(30));
				stmt1.setString(31, rs.getString(12));
				stmt1.setString(32, "");
				
				int i=stmt1.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println(e.getMessage());
			}  
			
			

		}
		rs.close();
		stmt.close();
		conn.close();
		return null;
	}

}
