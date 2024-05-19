package com.krunch.topicsearch.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.jdbc.core.RowMapper;

import com.krunch.topicsearch.entity.TopicDataModel;

import java.time.Duration;

public class TopicSearchContentDataMapper implements RowMapper<TopicDataModel> {

	java.sql.Date currentDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());

	@Override
	public TopicDataModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		
		TopicDataModel topicDataModel = new TopicDataModel();

		topicDataModel.setOgTitle(rs.getString("TopicOgTitle"));
		topicDataModel.setOgDescription(rs.getString("TopicOgDescription"));
		topicDataModel.setOgUrl(rs.getString("TopicOgUrl"));
		topicDataModel.setOgImage(rs.getString("TopicOgImage"));
		topicDataModel.setPopularity(rs.getInt("TopicUrlCount"));
		topicDataModel.setRelevancy(rs.getDouble("topicrnk"));
		topicDataModel.setCreatedAt(rs.getDate("CreatedAt"));

		if (topicDataModel.getOgDescription() != null && topicDataModel.getOgDescription().length() > 450) {
			topicDataModel.setOgDescription(topicDataModel.getOgDescription().substring(0, 450));
		}

		long difference_In_Time = currentDate.getTime() - topicDataModel.getCreatedAt().getTime();
		long difference_In_Days = TimeUnit.MILLISECONDS.toDays(difference_In_Time);
		
		topicDataModel.setRecency(difference_In_Days);

		float difference_in_weeks = (float) difference_In_Days / 7;

		// System.out.println("Created Date : " + topicDataModel.getCreatedAt() + "Days
		// Difference : " + difference_In_Days
		// + "Week Difference : " + difference_in_weeks);

		if (difference_in_weeks <= 1.0) {

			topicDataModel.setTimeInterval("< 1 Week");

		} else if (difference_in_weeks >= 1.0 && difference_in_weeks <= 2.0) {
			topicDataModel.setTimeInterval("< 2 Weeks");

		} else if (difference_in_weeks >= 2.0 && difference_in_weeks <= 4.0) {
			topicDataModel.setTimeInterval("> 2 Weeks");

		} else if (difference_in_weeks >= 4.0 && difference_in_weeks <= 8.0) {

			topicDataModel.setTimeInterval("> 1 Month");
		} else if (difference_in_weeks >= 8.0 && difference_in_weeks <= 12.0) {

			topicDataModel.setTimeInterval("> 2 Months");
		} else if (difference_in_weeks >= 12.0) {

			topicDataModel.setTimeInterval("> 3 Months");
		} else if (difference_in_weeks >= 52.0) {

			topicDataModel.setTimeInterval("One Year ago");
		}

	
		if (topicDataModel.getPopularity() <= 10) {
			topicDataModel.setTrendingStatus("fa-sm");

		} else if (topicDataModel.getPopularity() <= 25) {
			topicDataModel.setTrendingStatus("fa-lg");

		} else if (topicDataModel.getPopularity() > 25) {
			topicDataModel.setTrendingStatus("fa-2x");

		}

		if (difference_In_Days <= 15 && topicDataModel.getRelevancy() > 1.5 && topicDataModel.getPopularity() >= 8) {
			topicDataModel.setRating(5);

		}else if (topicDataModel.getRelevancy() >= 5 && topicDataModel.getPopularity() >= 5) {
			topicDataModel.setRating(5);

		}else if (topicDataModel.getRelevancy() >= 4
				) {
			topicDataModel.setRating(4);

		} else if (difference_In_Days <= 15 && topicDataModel.getRelevancy() > 2 && topicDataModel.getPopularity() >= 5
				&& topicDataModel.getPopularity() > 50) {
			topicDataModel.setRating(5);

		} else if (difference_In_Days <= 90 && topicDataModel.getRelevancy() >= 1.5
				) {
			topicDataModel.setRating(4);

		} else if (topicDataModel.getRelevancy() > 1.99 && topicDataModel.getPopularity() > 9) {
			topicDataModel.setRating(4);

		} else if (difference_In_Days <= 60 && topicDataModel.getRelevancy() > .90
				&& topicDataModel.getPopularity() > 50) {
			topicDataModel.setRating(4);
		} else if (difference_In_Days <= 90 && topicDataModel.getRelevancy() > .90
				&& topicDataModel.getPopularity() > 100) {
			topicDataModel.setRating(5);
		} else if (topicDataModel.getRelevancy() > .90 && topicDataModel.getPopularity() > 100) {
			topicDataModel.setRating(5);
		} else if (topicDataModel.getRelevancy() >= 1 && topicDataModel.getPopularity() > 60) {
			topicDataModel.setRating(4);
		} else if (topicDataModel.getRelevancy() >= 1.4 && topicDataModel.getPopularity() > 25) {
			topicDataModel.setRating(4);
		} else if (topicDataModel.getRelevancy() >= 1.3 && topicDataModel.getPopularity() > 5
				&& difference_In_Days < 8) {
			topicDataModel.setRating(4);
		} else if (topicDataModel.getRelevancy() > .90 && topicDataModel.getPopularity() > 9
				&& difference_In_Days < 16) {
			topicDataModel.setRating(4);

		}else if (topicDataModel.getRelevancy() < .2 && topicDataModel.getPopularity() <= 3
				) {
			topicDataModel.setRating(2);

		}

		else {
			topicDataModel.setRating(3);
		}

	//	System.out.println(topicDataModel.getRelevancy() + "#        " + topicDataModel.getPopularity() + "#        "
	//			+ difference_In_Days);

		return topicDataModel;
	}

}
