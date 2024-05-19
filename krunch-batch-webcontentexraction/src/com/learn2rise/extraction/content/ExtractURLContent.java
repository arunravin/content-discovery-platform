package com.learn2rise.extraction.content;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection.Response;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.learn2rise.extraction.content.model.TopicDataKeyConstants;

import de.l3s.boilerpipe.extractors.ArticleExtractor;

public class ExtractURLContent {

	private static Matcher matcher;
	private static final String DOMAIN_NAME_PATTERN = "([a-zA-Z0-9]([a-zA-Z0-9\\-]{0,61}[a-zA-Z0-9])?\\.)+[a-zA-Z]{2,15}";
	private static Pattern patrn = Pattern.compile(DOMAIN_NAME_PATTERN);

	public static void main(String[] args) throws Exception {
		// "https://www.finextra.com/channel/cloud";
		//https://www.gartner.com/reviews/market
		String urlString = "https://www.gartner.com/reviews/market/channel-integration-software";
		
		ExtractURLContent topicExtractor = new ExtractURLContent();

		Map<String, String> hmUrlContentandMetadata = topicExtractor.getURLContent(urlString);

		if (hmUrlContentandMetadata != null && !hmUrlContentandMetadata.isEmpty()) {
			for (Map.Entry<String, String> entry : hmUrlContentandMetadata.entrySet()) {
				 System.out.println(entry.getKey() + "$$$$$$$$" +
				 entry.getValue().toString());
			}

		}
	}

	public Map<String, String> getURLContent(String urlString) throws HttpStatusException, Exception {
		// String urlString = "https://goo.gl/UJw3mQ";
		String text = null;
		Map<String, String> hmUrlContentandMetadata = null;

		try {

			Response response = Jsoup.connect(urlString).ignoreContentType(true)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
					.referrer("http://www.google.com").timeout(20000).followRedirects(true).execute();
			Document urlResponseDoc = response.parse();

			 System.out.println(urlResponseDoc.html());

			hmUrlContentandMetadata = getURLMetaDataInfo(urlResponseDoc);

			String ogUrl = hmUrlContentandMetadata.get(TopicDataKeyConstants.OG_URL_KEY);

			text = ArticleExtractor.INSTANCE.getText(urlResponseDoc.html());

			if (text != null)
				hmUrlContentandMetadata.put("og:urlcontent", text);

			if (ogUrl != null) {
				Set<String> outGoingLinks = getHyperLinks(urlResponseDoc, ogUrl);
				hmUrlContentandMetadata.put("outgoinglinkscount", String.valueOf(outGoingLinks.size()));
				hmUrlContentandMetadata.put("outgoinglinksset", String.join("|", outGoingLinks));
			}

			// System.exit(1);

			// System.out.println("URL : " + urlString);
			// System.out.println("Extracted Text " + text);

		} catch (Exception e) {
			return null;
		}
		return hmUrlContentandMetadata;

	}

	public Set<String> getHyperLinks(Document doc, String url) {

		System.out.println("Get Hyper Links");
		Elements links = doc.select("a[href]");
		Set<String> result = new HashSet<>();
		String domainName = getDomainName(url);

		for (Element link : links) {
			String attr1 = link.attr("href");
			// if(attr1!=null && attr1.startsWith("http") && !attr1.contains(domainName)) {
			if (attr1 != null && attr1.split("/").length > 2) {
				if (!attr1.startsWith("http"))
					attr1 = "https://www.gartner.com" + attr1;
				result.add(attr1);
				System.out.println("URL " + attr1);
			}
		}

		Iterator<String> itr = result.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		return result;
	}

	public Map<String, String> getURLMetaDataInfo(Document doc) {

		Elements metatags = doc.select("meta");
		Map<String, String> metaDataMap = new HashMap<>();

		for (Element metainfo : metatags) {
			if (metainfo.hasAttr("name")) {
				metaDataMap.put(metainfo.attr("name"), metainfo.attr("content"));
				// System.out.println(metainfo.attr("name") + "**************** " +
				// metainfo.attr("content"));
			} else if (metainfo.hasAttr("property")) {
				metaDataMap.put(metainfo.attr("property"), metainfo.attr("content"));
				// System.out.println(metainfo.attr("property") + " ::::::::: " +
				// metainfo.attr("content"));
			}
		}
		// System.out.println(Arrays.asList(me taDataMap));
		return metaDataMap;
	}

	public String getDomainName(String url) {

		String domainName = "";
		matcher = patrn.matcher(url);

		if (matcher.find()) {
			domainName = matcher.group(0).toLowerCase().trim();
		}

		return domainName;
	}

	/*
	 * Document document = Jsoup.connect("https://www.tickld.com/ajax/login.php")
	 * .data("l_username", "myUsername") .data("l_password", "myPassword")
	 * .cookies(loginForm.cookies()) .post(); BAsicPipeLineExample ????
	 * 
	 */

}
