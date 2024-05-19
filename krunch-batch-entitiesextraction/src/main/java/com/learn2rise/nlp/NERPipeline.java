package com.learn2rise.nlp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;

import com.learn2rise.db.DataSource;

import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreEntityMention;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

public class NERPipeline {

	public static void main(String[] args) throws Exception {

		String strTopicText = "Biometrics Blockchain Drones Internet of Things Industrial Internet of Things Predictive Maintenance Smart Packaging Wearables\r\n"
				+ "Top 10 Industry 4.0 Trends & Innovations: 2020 & Beyond\r\n"
				+ "Our Innovation Analysts conducted an exhaustive analysis of 770 solutions and present the Top 10 Industry 4.0 Trends & Innovations in 2020 & beyond. Discover impactful manufacturing trends, promising startups & emerging companies, and our Global Startup Heat Map in this article!\r\n"
				+ "Related topics: Advanced Robotics Artificial Intelligence Big Data & Analytics Cloud Computing Cyber Security\r\n"
				+ "The concept of the fourth industrial revolution was first introduced in Hannover earlier in this decade. This followed several decades of industrial automation, albeit at lower levels of functionality and complexity. Many developments have since shaped several industry 4.0 technologies that were previously under the purview of researchers. This is possible today, mainly due to innovations in technology, software, and hardware. Already, the increasing human-machine, machine-machine, and human-human connectivity influence production systems and processes across the world. Industry 4.0 trends and technologies are fundamental in achieving connected manufacturing geared towards smart and autonomous factories.\r\n"
				+ "Innovation Map: Top 10 Industry 4.0 Trends\r\n"
				+ "Covering more than 1.116.000 startups & emerging companies, we use our proprietary StartUs Insights Platform to identify innovative applications and solutions that will impact the manufacturing sector in 2020 and beyond. Our Innovation Analysts conducted exhaustive data-driven research to identify the various innovation trends and technologies emerging in industry 4.0. For this research, we analyzed 770 startups and emerging companies and present the Top 10 Industry 4.0 Trends along with 20 highly relevant solutions for each of them.\r\n"
				+ "The Innovation Map below visualizes the major trends that impact the sector and showcases two hand-picked startups for each.\r\n"
				+ "Click to download\r\n" + " \r\n" + "Tree Map: The Impact Of Industry Trends On Industry 4.0\r\n"
				+ "The Tree Map below illustrates the top 10 industry 4.0 trends that will impact companies in 2020 and beyond. Employing artificial intelligence (AI) techniques across devices and processes forms the top industry 4.0 trend. Increasingly, emerging companies develop wearable solutions for the industrial workplace to ensure the safety and efficiency of the manufacturing process. Collecting data by implementing cloud and edge computing and designing cybersecurity solutions allow companies to establish the building blocks for setting up smart factories. Advanced robotic solutions comprising autonomous mobile robots, cobots, and swarm robotics, as well as robotic software development is also a major part of industry 4.0 trends.\r\n"
				+ "Click to download\r\n" + " \r\n"
				+ "Global Startup Heat Map: Industry 4.0 Startups & Emerging Companies\r\n"
				+ "For this analysis, we used a data-driven startup scouting approach to identify the most relevant solutions globally. The Global Startup Heat Map below highlights the global distribution of startups & emerging companies that also include the 20 promising examples out of 770 relevant industry 4.0 solutions.\r\n"
				+ "Click to download\r\n" + "1. Cyber Security, Transparency & Privacy\r\n"
				+ "The flow of information due to the connectedness in Industry 4.0 is raising concerns about security, transparency, and privacy. As the manufacturing practices are increasingly becoming personal and customizable, the data management practices done outside and within the shop floor will hugely influence the appeal of the company. The transmission and processing of sensitive industrial data need to be done securely to avoid cyberattacks on critical industrial facilities. Digital ethics and privacy, privacy-enhancing technologies, self adaptive security, zero-trust security, end-to-end communication security, DevSecOps, blockchain are some of the new developments in this front. The focus on cybersecurity needs to be balanced with transparency and privacy.\r\n"
				+ "Alias Robotics – Robot Immune System\r\n"
				+ "Spanish startup Alias Robotics  develops a robot immune system (RIS), an endpoint protection platform for robots. This solution provides malware protection to robots and robotic components. The modular architecture of RIS gives the system flexibility and adaptability and caters to a variety of robots. The company also offers a secure data recorder for investigating cyber attacks or malfunctions in robots. The use of industrial robots in all stages of manufacturing is necessitating innovations like RIS.\r\n"
				+ "Adolus – Secure Software Updates\r\n"
				+ "Industry 4.0 makes use of smart, connected devices sourced from multiple vendors. These devices need to be updated constantly with the latest software, firmware, and configuration files. Adolus is a Canadian startup providing a secure update process for embedded devices. Cybercriminals potentially interfere with the upgrading process and compromise industrial facilities by tricking the staff into installing infected files. Adolus develops FACT, which solves this problem by working with equipment vendors to collect unique fingerprints of the files and compares these fingerprints with the ones received by the manufacturers. FACT gives a confidence rating during installation as well as visibility over the upgrading processes in critical systems.\r\n"
				+ "2. Edge, Fog & Cloud Computing\r\n"
				+ "The immense amount of data being generated by the industrial internet of things (IIoT) is propelling the adoption of edge, fog, and cloud computing capabilities in Industry 4.0. Custom hardware and software solutions like connected clouds, distributed clouds, distributed compute and storage, hybrid computing, low code development platforms, microservices, mobile computing, and multi-access edge computing are shaping up this industry 4.0 trend.\r\n"
				+ "Edgise – AI-Powered Edge Computing\r\n"
				+ "Belgian startup Edgise  provides hardware development as a service for edge computing applications. The startup shortens response time by moving AI from the cloud to the edge. The optimal performance of industrial systems depends on the efficient execution of the algorithm present in the machines. Edge computing facilities, along with IIoT, greatly improve the speed, security, and efficiency of the manufacturing process by accelerating the running of algorithms. The company provides support to the entire edge computing product development cycle.\r\n"
				+ "Atrio – Hybrid Cloud Computing\r\n"
				+ "The US-based startup Atrio offers the Atrio Hybrid Composable Cloud, a software-defined single computing platform. Cloud computing capabilities improve manufacturing cycle times by providing quick insights into all steps in manufacturing. The platform made by Atrio offers a single cloud-agnostic computing network that integrates common infrastructure and cloud services for creating, managing, and operating hybrid and multi-cloud environments.\r\n"
				+ "3. Artificial Intelligence\r\n"
				+ "AI and machine learning are driving innovations across industries and functional areas. AI-specific hardware and new algorithms are being developed to optimize the existing systems and tackle new challenges facing manufacturing. Factories are beginning to integrate AI across their production systems and processes. Advanced AI makes it possible to conduct predictive maintenance, cognitive computing, swarm intelligence, context-aware computing, smart machines, hardware accelerators, and generative design. All of these technologies propel manufacturing facilities to move towards complete lights-out manufacturing.\r\n"
				+ "Mechanica AI – Production Grade AI\r\n"
				+ "Mechanica AI  is a Dutch startup that offers production-grade AI for industrial operations. The technology enables the manufacturers to extract value from limited or imperfect datasets. They have incorporated industry domain knowledge into the AI system for delivering optimal performance. The solution enables using imperfect manufacturing data for autonomous decision making and process control. In addition, these AI products integrate with legacy assets, allowing more factories to adopt technology solutions.\r\n"
				+ "Oqton – AI-Powered Data Integration\r\n"
				+ "The US-based startup Oqton develops FactoryOS, an AI-powered platform for integrating manufacturing system data in order to streamline factory production and output. Machines, systems, and data from manufacturing facilities are usually kept as independent data silos, making it difficult to derive actual value from them. The cloud-based platform integrates and uses data from all stages of the industrial ecosystem such as design, production, and supply chain. Over time, the AI learns continuously from these data inputs to generate critical insights for improving overall productivity.\r\n"
				+ "4. Human Augmentation & Extended Reality (XR)\r\n"
				+ "The physical and cognitive augmentation of humans forms another major industry 4.0 trend. The limitations in humans are being augmented with the help of technologies such as wearables and exoskeletons. Further, industrial mobile devices, natural and intuitive UI, and portable machine control screens enhance the ease of using such technology. XR technologies like mixed reality (MR) , augmented reality (AR) , and virtual reality (VR) are already in use in Industry 4.0 from the research and development (R&D) to full-scale production and post-production processes. This multi-experience paradigm is changing the way industrial manufacturing systems function. The nature of human-machine interaction is aligning more toward machine-enabled workers.\r\n"
				+ "ULS Robotics – Exoskeleton Technology Platform\r\n"
				+ "ULS Robotics  is a Chinese startup developing an exoskeleton technology platform. Many workers on the shopfloor encounter fatigue, weakness, and other physical discomforts due to the repetitive and monotonous nature of their tasks. The use of exoskeletons on the shop floor helps workers in doing their tasks efficiently while reducing or eliminating any physical strain. Exoskeletons usually provide support for the waist, upper limb (with 4 degrees of freedom), and lower limb (with 12 degrees of freedom).\r\n"
				+ "VirtuFab – Virtual Fabrication\r\n"
				+ "The US-based startup VirtuFab  develops an enterprise-level VR tool aiming to assist manufacturing and fabrication teams for product design and pre-visualization processes. Product design requires tight collaboration among team members and extends to multidisciplinary team coordination. The use of VR for this process enables direct location-agnostic access to the designs. Virtufab offers a virtual customizable tool belt that enables remote collaboration capabilities.\r\n"
				+ "5. Network & Connectivity\r\n"
				+ "Network and connectivity are among the main driving forces in enabling Industry 4.0. A number of technology developments such as edge-to-cloud, gigabit ethernet time-sensitive networks, low-power wide-area network (LPWAN), 5G , machine-to-machine communication (M2M), real-time deterministic ethernet, time-sensitive networking (TSN), ubiquitous radio access, unified IoT framework, and zero-touch networks nudge factories to implement IIoT to transform into Industry 4.0 facilities. These technologies constantly improve machine-machine and human-machine communication, as well as data transmission. As a result, innovations in this area increase speed, improve security and efficiency, and reduce the cost of network connectivity.\r\n"
				+ "BehrTech – Low Power Wide Area Networks (LPWAN)\r\n"
				+ "BehrTech is a Canadian startup developing MIOTY, an LPWAN solution standardized by the European Telecommunications Standards Institute for IIoT. LPWAN solutions are ideal for connecting numerous machines in industrial complexes as they have a sufficient range and low implementation costs. BehrTech uses Fraunhofer’s patented Telegram Splitting protocol, wherein a message is split into multiple smaller sub-packets and sent at different times and frequencies. It enables interference resilience, massive scalability, extensive coverage, and ultra-low power consumption.\r\n"
				+ "Coretigo – Wireless IIoT Communication\r\n"
				+ "Israeli startup Coretigo  offers a wireless IIoT communication service based on the IO-Link Wireless standard. IO- link is a communication protocol that works point to point and is usually wired. The IO-Link Wireless design allows it to handle a large number of devices while maintaining low latency and high reliability. Coretigo helps in wireless communication between sensors, actuators, and controllers.\r\n"
				+ "Looking for specific industry 4.0 startups and technologies?\r\n";

		getEntityMentionsforTopicContent(strTopicText);
	}

	private static void getEntityMentionsforTopicContent(String strTopicText) throws Exception {

		// set up pipeline properties
		Properties props = new Properties();
		props.setProperty("annotators", "tokenize,ssplit,pos,lemma,ner");

		// set up pipelineK
		StanfordCoreNLP pipeline = new StanfordCoreNLP(props);
		// make an example document

		Map<String, String> hmTopicUrlandContent = getTopicURLandContent();

		for (Map.Entry<String, String> entry : hmTopicUrlandContent.entrySet()) {
			//System.out.println("Key **************** = " + entry.getKey());

			CoreDocument doc = new CoreDocument(entry.getValue()); // annotate the document
			pipeline.annotate(doc); // view results System.out.println("---");
			// System.out.println("entities found");

			Map<String, String> hmOrganizationEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmPersonEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmLocationEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmTitleEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmDateEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmDurationEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmMoneyEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmHandlerEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmNumberEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmNationalityEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmCountryEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmCityEntitiesMentions = new HashMap<String, String>();
			Map<String, String> hmStateorProvinceMentions = new HashMap<String, String>();
			Map<String, String> hmURLEntitieseMentions = new HashMap<String, String>();
			Map<String, String> hmMiscEntitieseMentions = new HashMap<String, String>();
			Map<String, String> hmOrdinalEntitieseMentions = new HashMap<String, String>();

			for (CoreEntityMention em : doc.entityMentions()) {

				switch (em.entityType()) {

				case "ORGANIZATION" -> hmOrganizationEntitiesMentions.put(em.text(), em.entityType());
				case "PERSON" -> hmPersonEntitiesMentions.put(em.text(), em.entityType());
				case "COUNTRY" -> hmCountryEntitiesMentions.put(em.text(), em.entityType());
				case "NATIONALITY" -> hmNationalityEntitiesMentions.put(em.text(), em.entityType());
				case "CITY" -> hmCityEntitiesMentions.put(em.text(), em.entityType());
				case "LOCATION" -> hmLocationEntitiesMentions.put(em.text(), em.entityType());
				case "STATE_OR_PROVINCE" -> hmStateorProvinceMentions.put(em.text(), em.entityType());
				case "URL" -> hmURLEntitieseMentions.put(em.text(), em.entityType());
				case "TITLE" -> hmTitleEntitiesMentions.put(em.text(), em.entityType());
				case "DATE" -> hmDateEntitiesMentions.put(em.text(), em.entityType());
				case "DURATION" -> hmDurationEntitiesMentions.put(em.text(), em.entityType());
				case "MISC" -> hmMiscEntitieseMentions.put(em.text(), em.entityType());
				case "ORDINAL" -> hmOrdinalEntitieseMentions.put(em.text(), em.entityType());
				case "HANDLE" -> hmHandlerEntitiesMentions.put(em.text(), em.entityType());
				case "MONEY" -> hmMoneyEntitiesMentions.put(em.text(), em.entityType());

				}

			}

			String strOrganizationEntities = convertMapKeysToText(hmOrganizationEntitiesMentions);
			strOrganizationEntities = strOrganizationEntities != null ? strOrganizationEntities : "";
			System.out.println("Organizaton Entities :" + strOrganizationEntities);

			String StrPersonEntities = convertMapKeysToText(hmPersonEntitiesMentions);
			StrPersonEntities = StrPersonEntities != null ? StrPersonEntities : "";
			//System.out.println("Person Entities :" + StrPersonEntities);

			String strCountryEntities = convertMapKeysToText(hmCountryEntitiesMentions);
			strCountryEntities = strCountryEntities != null ? strCountryEntities : "";
			//System.out.println("Country Entities :" + strCountryEntities);

			String StrNationalityEntities = convertMapKeysToText(hmNationalityEntitiesMentions);
			StrNationalityEntities = StrNationalityEntities != null ? StrNationalityEntities : "";
			//System.out.println("National Entities :" + StrNationalityEntities);

			String StrLocationEntities = convertMapKeysToText(hmLocationEntitiesMentions);
			StrLocationEntities = StrLocationEntities != null ? StrLocationEntities : "";
			//System.out.println("Location Entities :" + StrLocationEntities);

			String StrCityEntities = convertMapKeysToText(hmCityEntitiesMentions);
			StrCityEntities = StrCityEntities != null ? StrCityEntities : "";
			//System.out.println("City Entities :" + StrCityEntities);

			String StrURLEntities = convertMapKeysToText(hmURLEntitieseMentions);
			StrURLEntities = StrURLEntities != null ? StrURLEntities : "";
			//System.out.println("URL Entities :" + StrURLEntities);

			String strTitleEntities = convertMapKeysToText(hmTitleEntitiesMentions);
			strTitleEntities = strTitleEntities != null ? strTitleEntities : "";
			//System.out.println("Title Entities :" + strTitleEntities);

			String StrDateEntities = convertMapKeysToText(hmDateEntitiesMentions);
			StrDateEntities = StrDateEntities != null ? convertMapKeysToText(hmDateEntitiesMentions) : "";

			String strDurationEntities = convertMapKeysToText(hmDurationEntitiesMentions);
			strDurationEntities = strDurationEntities != null ? strDurationEntities : "";

			String StrMiscEntitieseMentions = convertMapKeysToText(hmMiscEntitieseMentions);
			StrMiscEntitieseMentions = StrMiscEntitieseMentions != null ? StrMiscEntitieseMentions : "";

			String StrOrdinalEntitieseMentions = convertMapKeysToText(hmOrdinalEntitieseMentions);
			StrOrdinalEntitieseMentions = StrOrdinalEntitieseMentions != null ? StrOrdinalEntitieseMentions : "";

			String strHandlerEntities = convertMapKeysToText(hmHandlerEntitiesMentions);
			strHandlerEntities = strHandlerEntities != null ? strHandlerEntities : "";

			String StrMoneyEntities = convertMapKeysToText(hmMoneyEntitiesMentions);
			StrMoneyEntities = StrMoneyEntities != null ? StrMoneyEntities : "";

			// System.out.println("\tdetected entity: \t" + em.text() + "\t" +
			// em.entityType());
			System.out.println("End  **************** = ");
			doc = null;

			String updateQuery = "UPDATE \"Gartner_TopicEntityData\""
					+ "	SET  \"OrganizationEntities\"=?, \"PersonEntities\"=?, \"LocationEntities\"=?, \"MiscEntities\"=?, "
					+ "		 \"TitleEntities\"=?, \"DateEntities\"=?, \"DurationEntities\"=?, \"MoneyEntities\"=?, "
					+ "		 \"HandleEntities\"=?, \"NationalityEntities\"=?, \"CountryEntities\"=?, \"CityEntities\"=? "
					+ "	WHERE \"TopicOgUrl\"=?";

			Connection conn = DataSource.getConnection();
			PreparedStatement pst = null;

			try {

				pst = conn.prepareStatement(updateQuery);

				pst.setString(1, strOrganizationEntities);
				pst.setString(2, StrPersonEntities);
				pst.setString(3, StrLocationEntities);
				pst.setString(4, StrMiscEntitieseMentions);
				pst.setString(5, strTitleEntities);
				pst.setString(6, StrDateEntities);
				pst.setString(7, strDurationEntities);
				pst.setString(8, StrMoneyEntities);
				pst.setString(9, strHandlerEntities);
				pst.setString(10, StrNationalityEntities);
				pst.setString(11, strCountryEntities);
				pst.setString(12, StrCityEntities);

				pst.setString(13, entry.getKey());

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

	}

	private static Map<String, String> getTopicURLandContent() throws SQLException {
		Statement stmt = null;

		Connection conn = DataSource.getConnection();
		stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("select  \"TopicOgUrl\", \"TopicOgUrlContent\" , \"TopicOutGoingLinksUrlSet\" "
						+ "from \"Gartner_TopicEntityData\"\r\n"
						+ "where \"TopicOgUrlContent\" <> '' and \"OrganizationEntities\" is  null  ");
		Map<String, String> hmTopicUrlandContent = new HashMap<String, String>();
		while (rs.next()) {

			String url = rs.getString(1);
			String text = rs.getString(2);

			// System.out.println( "ID = " + url );
			// System.out.println( "Content = " + text );

			hmTopicUrlandContent.put(url, text);

		}
		
		System.out.println("Batch Size : " + hmTopicUrlandContent.size());
		
		
		rs.close();
		stmt.close();
		conn.close();
		return hmTopicUrlandContent;
	}

	private static String convertMapKeysToText(Map<String, String> hmEntitiesMap) {

		String[] entitiesMentions = hmEntitiesMap.keySet().toArray(new String[0]);
		String strEntitiesMentions = null;

		if (entitiesMentions != null && entitiesMentions.length > 0) {

			StringJoiner joiner = new StringJoiner("|");
			for (int i = 0; i < entitiesMentions.length; i++) {
				joiner.add(entitiesMentions[i]);
			}

			strEntitiesMentions = joiner.toString();

		}
		// System.out.println("Extracted Entities 123: "+strEntitiesMentions);
		return strEntitiesMentions;
	}

}