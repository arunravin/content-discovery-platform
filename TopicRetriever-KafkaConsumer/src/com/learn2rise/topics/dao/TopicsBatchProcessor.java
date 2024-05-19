package com.learn2rise.topics.dao;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.learn2rise.topics.datasource.DataSource;
import com.learnnrise.topics.consumer.TopicVO;

public class TopicsBatchProcessor {

	public static void main(String[] args) {

	}

	public static void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public static void parameterizedBatchUpdate(List<TopicVO> lstTopics) {

		//System.out.println("Enter parameterizedBatchUpdate Batch Size ***********************" + lstTopics.size());

		Date date = new Date();
		String INSERT_USERS_SQL = "INSERT INTO public.\"Topics\"(\"Id\",\"OriginalText\", \"TransformedText\", \"CreatedAt\", \"RetweetCount\","
				+ "	\"FavouriteCount\", \"TopicUrl\", \"TopicTags\", \"SharedCount\", \"LikedCount\","
				+ "	\"Location\", \"FollowersCount\", \"FollowingCount\" )" + "	VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try (Connection connection = DataSource.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			    connection.setAutoCommit(false);

			if (lstTopics != null && lstTopics.size() > 0) {

				for (TopicVO topicVO : lstTopics) {

					preparedStatement.setInt(1, (int) topicVO.getId());
					preparedStatement.setString(2, topicVO.getOriginalText().toString());
					preparedStatement.setString(3, topicVO.getTransformedText().toString());
					preparedStatement.setTimestamp(4, new Timestamp(date.getTime()));
					preparedStatement.setInt(5, topicVO.getRetweetCount());
					preparedStatement.setInt(6, topicVO.getLikedCount());
					preparedStatement.setString(7, topicVO.getTopicUrl().toString());
					preparedStatement.setString(8,
							topicVO.getTopicTags() != null ? topicVO.getTopicTags().toString() : "");
					preparedStatement.setInt(9, topicVO.getSharedCount());
					preparedStatement.setInt(10, topicVO.getLikedCount());
					preparedStatement.setString(11,
							topicVO.getLocation() != null ? topicVO.getLocation().toString() : "");
					preparedStatement.setInt(12, topicVO.getFollowersCount());
					preparedStatement.setInt(13, topicVO.getFollowingCount());
					preparedStatement.addBatch();

				}

				int[] updateCounts = preparedStatement.executeBatch();
				System.out.println(Arrays.toString(updateCounts));
				connection.commit();
				connection.setAutoCommit(true);

			}

		} catch (Exception exp) {

			exp.printStackTrace();
		}

	}

	public static void printBatchUpdateException(BatchUpdateException b) {

		System.err.println("----BatchUpdateException----");
		System.err.println("SQLState:  " + b.getSQLState());
		System.err.println("Message:  " + b.getMessage());
		System.err.println("Vendor:  " + b.getErrorCode());
		System.err.print("Update counts:  ");
		int[] updateCounts = b.getUpdateCounts();

		for (int i = 0; i < updateCounts.length; i++) {
			System.err.print(updateCounts[i] + "   ");
		}
	}
}
