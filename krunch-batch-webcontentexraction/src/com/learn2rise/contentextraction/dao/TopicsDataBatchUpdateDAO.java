package com.learn2rise.contentextraction.dao;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.postgresql.util.PSQLException;

import com.learn2rise.contentextraction.datasource.DataSource;
import com.learn2rise.extraction.content.model.TopicDataModel;

public class TopicsDataBatchUpdateDAO {

	public static void main(String[] args) {

	}

	public static void parameterizedBatchUpdate(List<TopicDataModel> lstTopics) {

		// System.out.println(\"Enter parameterizedBatchUpdate Batch Size
		// ***********************\" + lstTopics.size());

		Date date = new Date();

		String INSERT_Topic_DATA_SQL = "INSERT INTO public.\"TopicEntityData\"("
				+ "\"TopicOgUrl\", \"TopicOgDescription\", \"TopicOgTitle\", \"TopicOgImage\", "
				+ "\"TopicOgUrlContent\", \"Keywords\", \"TopicUrlCount\", \"TransformedText\","
				+ "\"TopicOgLocale\", \"ArticlePublishedTime\",\"ArticleModifiedTime\", \"CreatedAt\"," 
				+ "\"ArticleAuthor\",\"TopicSourceUrl\",\"TopicOutGoingLinksUrlSet\",\"TopicOutGoingLinksCount\") "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?)";

		try (Connection connection = DataSource.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_Topic_DATA_SQL)) {
			// connection.setAutoCommit(false);

			if (lstTopics != null && lstTopics.size() > 0) {
				for (TopicDataModel topicModelVO : lstTopics) {

					

						preparedStatement.setString(1, topicModelVO.getOgUrl().toString());
						preparedStatement.setString(2,
								topicModelVO.getOgDescription() != null ? topicModelVO.getOgDescription().toString()
										: "");
						preparedStatement.setString(3,
								topicModelVO.getOgTitle() != null ? topicModelVO.getOgTitle().toString() : "");
						preparedStatement.setString(4,
								topicModelVO.getOgImage() != null ? topicModelVO.getOgImage().toString() : "");

						preparedStatement.setString(5,
								topicModelVO.getOgUrlContent() != null ? topicModelVO.getOgUrlContent().toString()
										: "");
						preparedStatement.setString(6,
								topicModelVO.getKeywords() != null ? topicModelVO.getKeywords().toString() : "");

						preparedStatement.setInt(7, topicModelVO.getUrlCount());
						preparedStatement.setString(8, topicModelVO.getTransformedText());

						preparedStatement.setString(9,
								topicModelVO.getOgLocale() != null ? topicModelVO.getOgLocale().toString() : "");
						if (topicModelVO.getArticlePublishedTime() != null) {
							preparedStatement.setString(10, topicModelVO.getArticlePublishedTime());
						} else {
							preparedStatement.setString(10, "");
						}
						if (topicModelVO.getArticleModified_time() != null) {
							preparedStatement.setString(11, topicModelVO.getArticleModified_time());
						} else {
							preparedStatement.setString(11, "");
						}
						
						preparedStatement.setTimestamp(12, new Timestamp(date.getTime()));
						
						if (topicModelVO.getArticleAuthor() != null) {
							preparedStatement.setString(13, topicModelVO.getArticleAuthor().toString());
						} else {
							preparedStatement.setString(13, "");
						}

						preparedStatement.setString(14, topicModelVO.getSourceUrl());
						// preparedStatement.addBatch();

						if (topicModelVO.getTopicOutGoingLinksSet() != null) {
							preparedStatement.setString(15, topicModelVO.getTopicOutGoingLinksSet());
							preparedStatement.setInt(16, topicModelVO.getTopicOutgoingLinksCount());
						} else {

							preparedStatement.setString(15, "");
							preparedStatement.setInt(16, 0);
						}

						System.out.println("New Topic :" + topicModelVO.getOgUrl().toString());

					

				}

				int updateCounts = preparedStatement.executeUpdate();

				// connection.commit();
				// connection.setAutoCommit(true);

			}

		} catch (PSQLException exp) {
			exp.printStackTrace();
			System.out.println(exp.getMessage().toString());
		} catch (Exception exp) {
			exp.printStackTrace();
			System.out.println(exp.getMessage().toString());
		}

	}

	public static boolean checkandUpdateTopicCount(String topicUrl, int topicCount) {

		boolean topicUpdated = false;
		Date date = new Date();

		String SELECT_TOPIC_QUERY = " select \"TopicOgUrl\" , \"TopicUrlCount\" from \"TopicEntityData\" where "
				+ "\"TopicOgUrl\" = '" + topicUrl + "' limit 1 ";

		String TOPIC_UPDATE_QUERY = " Update \"TopicEntityData\" set \"TopicUrlCount\" =  ? , \"UpdatedAt\" =  ?  where "
				+ " \"TopicOgUrl\" = ?";

		try (Connection con = DataSource.getConnection();
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(SELECT_TOPIC_QUERY)) {

			if (rs.next()) {

				int existingTopicCount = rs.getInt(2);
				int totalCount = topicCount + existingTopicCount;

				PreparedStatement pstmt = con.prepareStatement(TOPIC_UPDATE_QUERY);

				pstmt.setInt(1, totalCount);
				pstmt.setTimestamp(2, new Timestamp(date.getTime()));
				pstmt.setString(3, topicUrl);

				int affectedrows = pstmt.executeUpdate();

				System.out.println("Previous Count" + existingTopicCount + "Updated Url : " + topicUrl + "Final Count "
						+ totalCount);

				if (affectedrows > 0)
					topicUpdated = true;
			}

		} catch (SQLException ex) {

			ex.printStackTrace();
			System.out.println(ex.getLocalizedMessage());
		}

		return topicUpdated;
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
