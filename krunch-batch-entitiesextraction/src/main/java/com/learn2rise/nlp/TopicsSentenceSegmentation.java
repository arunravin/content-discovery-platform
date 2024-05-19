package com.learn2rise.nlp;

import java.io.Reader;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.learn2rise.db.DataSource;

import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.SentenceUtils;
import edu.stanford.nlp.process.DocumentPreprocessor;

public class TopicsSentenceSegmentation {

	public static void main(String[] args) throws Exception {

		String paragraph = "The demand for Data Science skills are expected to drive a 27.9 % increment in employment in the field"
				+ " by 2026 – says U.S. Bureau of Labor Statistics reports.Data Science has become a prominent work field because"
				+ " of its ability to help businesses take actions, decisions based on deduced facts, statistical numbers, and trends"
				+ " from raw and scattered data. If you are someone who is stuck at “why become a data scientist”, here are your 3 great reasons: Pay is great (a folk can take home an annual average salary of $113,436). Learning filled career (you are always tossed with great innovations to learn & grow). Recession-proof (there is a skill-gap, great chance to reskill in this field via Data Science Training & tap on the job market with great confidence). So if you are done understanding “why become a Data Scientist”, let’s take you to another major concern of “what skills you need to become a Data Scientist”. Before you hunt for “steps to become a Data Scientist”, “How to Become a Data Scientist”, or more specifically “ how to become a Data Scientist in 6 months”, know the 10 must-have skills/steps to become a Data Scientist in 2020 and beyond. 10 Must-have Skills to Become a Data Scientist Probability and statistics Data Science is a process of combining processes, systems, algorithms, tools to extract the insights or knowledge from the datasets – to further take actions and decisions based on drawn insights. Probability and statistics are part and parcel of the Data Science process, that helps with making clear predictions, estimations, inferences for helping with analysis.  The probability and statistics are intertwined, which helps with: Understanding the underlying relationships or dependencies between different data or variables. Defining motive or pattern of data. Defining future trends. Exploring and gaining more inputs on data. Programming Languages – Python and  R Data science involves procuring, cleaning, and organizing of data – for which statistical programming languages are must that helps in the purpose. The popular programming languages that are used in conjunction with Data Science are R and Python.  Why Data Science with R & Python? “Over 50% of Data Scientists are skilled in Data Science with R or Python”. R as a statistical language helps with statistical analysis and learnings via its rich libraries & capabilities. Python with its better coordination with Machine Learning is a fit when data analysis tasks are ready to be aligned with the web applications. Data Science without knowledge of programming/coding is damn difficult. Therefore, it is recommended to get well-versed with programming languages like R or Python first. Machine Learning As a Data Scientist, you would be required to transform the business problems into Machine learning tasks.  After procuring the datasets: You will be required to feed the data with suitable ML algorithms.  ML will further process these datasets via suitable algorithms and data-driven models. The machine you are training will learn how to predict the data pattern and will know how to produce accurate results in the future.  As a Data Scientist, you should know every inch of Machine Learning concepts like random forests, k-nearest neighbours’ algorithms, and more such concepts application in real-time. Data Wrangling With too many datasets to deal with, there it becomes difficult to handle them at times. Errors in datasets, missing values, ill-format are few things which are common to have. Thus, as a Data Scientist:  You should be aware of Data Wrangling or Data Munging skills – which is a process of cleaning and structuring the data into a readable format — so that better insights & decisions can be made timely. You need to be aware of the Data Wrangling & Mungling process, tools to make any complex to simplified data neat & approachable for further analysis. Data Visualization Data Visualization skills are important when you are working in a large data-driven organization – where both technical and non-technical professionals coexist. Data Visualization Skills: You are better able to explain and narrate your findings on the data via neat and easy to understand graphical representations or visuals as bar graphs, pie charts, maps, and more.  You can easily make anyone understand trends, outliners, patterns that you have found in the datasets. Since visuals are interpreted faster than inscribed texts, the Data Visualization with Tableau tools can come handy to explain the insights that you have discovered, without much talking. Big Data Data Scientists’ job is all about managing different, complex to simple structured & unstructured datasets.  Thus as a Data Scientist: You need to know how to interact and deal with any complex to simple big data. More like how to clean it, organize it, and manage it for further analysis. To interact with Big Data, tools like Hadoop come handy, as they help to prepare, process, and simply the big data for further processing.  You need to know how to manage big data with various tools & techniques in stages like – data exploration, data sampling, data filtering, data summarization. Data Intuition Like a palm reader, you need to apply great intuition while transforming datasets.  Thus, as a Data Scientist: You should have an understanding of how to apply your Data Science skills with statistics, maths, programming, Big Data Analytics, to get the best & desired solutions in the end. You need to be intuitive and know what kind of combination of activities, tools, skills, processes are needed to be applied in what case, to get the best outcome. These intuitions, however, can be learned while you decide to join a Data Science Training and Certification program that runs on real-time projects solving. Storytelling  Just like you tell stories to young kids, you have to be a great storyteller,  here the slight difference is –  you have to tell stories to the corporates or the stakeholders.  Thus, as a Data Scientist: You need to have the skills to narrate the data’s journey and insights into the most suitable and simplified format – which your associates or superiors can understand.  You need to know how to demonstrate your findings into a clear-cut story – that can further get understood by the decision-makers, asap. Again, nobody is born with storytelling as a gift, however, when you will approach the Data Science certification training programs with real-time project solving – you will have a broader chance to gain traction with how to narrate a data story with ease. Business Acumen You as a Data Scientist are not just subjected to transforming data, you should also have some clarity on how that data transformation can help the business grow and sustain. Thus, as a Data Scientist: You should think from a complete business model’s perspective.  Should know how to tackle the business challenges and transform them into opportunities and then into successful results to drive the positive fate of the organization. You should have strong business acumen – wherein you work on helping businesses tapping on new opportunities and chances that they are missing out on lifting their business graph.  Strong Communication & Collaboration skills Data Scientists don’t work in isolation, they work in unison with various junior to senior analysts, business teams or so – with whom they are required to talk and communicate on a constant basis. Thus, as a Data Scientist: You should know how to communicate and collaborate timely with the members easily – to get helped in making advancements in the process of data transformation.  Reach out to everyone and be easy to reach for everyone to get the collective results — which are efficient and effective for you, your associated members, and the organization overall. Summing Up on 10 Skills to Become a Data Scientist! Great pay, innovation, skill-gap are the few reasons that pretty much answers your query “Why become a Data Scientist”.  Before hunting for “how to become a data scientist”, “how to become a data scientist in 6 months”, “steps to become Data Scientists”, you need to look for ways to sharpen the above 10 skills/steps to become a Data Scientist.";

		System.out.println();
		String trimmedDescription = "";

		String updateQuery = "UPDATE \"TopicContentData\"" + "	SET  \"TopicOgDescription\"=? WHERE \"TopicOgUrl\"=?";

	
		Map<String, String> hmTopicUrlandDesc = getTopicURLandDescription();

		for (Map.Entry<String, String> entry : hmTopicUrlandDesc.entrySet()) {
			System.out.println("Key **************** = " + entry.getKey());
			Connection conn = DataSource.getConnection();
			PreparedStatement pst = null;

			trimmedDescription = getFirstTwoSentences(entry.getValue());

			try {

				pst = conn.prepareStatement(updateQuery);
				pst.setString(1, trimmedDescription);
				pst.setString(2, entry.getKey());
				int updateCount = pst.executeUpdate();
				System.out.println("Update Count : " + updateCount);

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

			if (conn != null)
				conn.close();
			if (pst != null)
				pst.close();

		}

		System.out.println("Trimmed Description : " + trimmedDescription);
	}

	

	private static String getFirstTwoSentences(String paragraph) {
		Reader reader = new StringReader(paragraph);
		DocumentPreprocessor dp = new DocumentPreprocessor(reader);
		List<String> sentenceList = new ArrayList<String>();
		List<String> descriptionSubList = new ArrayList<String>();
		String trimedDescription = null;

		if (paragraph != null) {
			for (List<HasWord> sentence : dp) {
				// SentenceUtils not Sentence
				String sentenceString = SentenceUtils.listToString(sentence);
				sentenceList.add(sentenceString);
			}

			// System.out.println(sentenceList.subList(0,1));
			descriptionSubList = sentenceList.subList(0, 1);

			trimedDescription = String.join("", descriptionSubList);
		}

		return trimedDescription;

	}

	private static Map<String, String> getTopicURLandDescription() throws SQLException {
		Statement stmt = null;

		Connection conn = DataSource.getConnection();
		stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("select distinct \"TopicOgUrl\", \"TopicOgDescription\" from \"TopicContentData\"\r\n"
						+ "where \"TopicOgDescription\" <> '' and  length( \"TopicOgDescription\") > 250  ");
		System.out.println("After executing resultset ");

		Map<String, String> hmTopicUrlandDescription = new HashMap<String, String>();
		while (rs.next()) {

			String url = rs.getString(1);
			String text = rs.getString(2);

			// System.out.println( "ID = " + url );
			// System.out.println( "Content = " + text );

			hmTopicUrlandDescription.put(url, text);

		}
		rs.close();
		stmt.close();
		conn.close();
		return hmTopicUrlandDescription;
	}

}
