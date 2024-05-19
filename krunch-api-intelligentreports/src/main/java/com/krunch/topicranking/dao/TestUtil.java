package com.krunch.topicranking.dao;

import java.net.URL;

public class TestUtil {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//String strOutGoingLinks = "https://finance.yahoo.com/news/takung-art-32-hope-adopt-130318450.html|https://cointelegraph.com/news/wild-west-as-developers-macgyver-highly-popular-nfts-on-cardano|https://feeds.feedburner.com/InvestorPlace|https://www.facebook.com/investorplace/|https://twitter.com/InvestorPlace|https://www.reddit.com/r/cardano/comments/migj1f/we_just_minted_our_first_nfts_on_the_cardano/";
		
		String strOutGoingLinks = "https://boards.greenhouse.io/coindesk|https://downloads.coindesk.com/Coindesk_MediaKit_2021_Q2.pdf|https://facebook.com/coindesk|https://dcg.co/#digital-assets-portfolio|https://www.gettyimages.com/detail/news-photo/muhammad-ali-steps-away-from-a-roundhouse-left-thrown-by-news-photo/619119366?adppopup=true|https://twitter.com/coindesk|https://twitter.com/JamieCrawleyCD|https://dcg.co|https://ethernity.io/|https://dcg.co/portfolio|https://edition.cnn.com/2021/03/08/sport/muhammad-ali-joe-frazier-the-fight-of-the-century-cmd-spt-intl/index.html|https://linkedin.com/company/coindesk";		
		String[] topicKeyWords = { "nft", "fungible", "token", "art", "crypto", "asset", "invest", "ethereum",
				"blockchain" };

		double outBoundLinksScore = 0.00;

		if (strOutGoingLinks != null && strOutGoingLinks.length() > 25) {
			String[] arrOutGoingLink = strOutGoingLinks.split("\\|");

			for (int i = 0; i < arrOutGoingLink.length; i++) {

				System.out.println(arrOutGoingLink[i]);

				URL url = new URL(arrOutGoingLink[i]);

				if (url.getPath() != null && url.getPath().split("/").length - 1 > 1) {

					if (url.getPath().split("-").length - 1 > 3 || url.getPath().split("_").length - 1 > 3) {

						outBoundLinksScore = outBoundLinksScore + 0.5;

						System.out.println("OutBound Links containes valid titles : " + outBoundLinksScore);
					}

					for (String topicKeyWord : topicKeyWords) {

						if (url.getPath().toLowerCase().contains(topicKeyWord)) {

							outBoundLinksScore = outBoundLinksScore + 0.5;
							System.out.println("OutBound Links containes Keywords : " + outBoundLinksScore);

							break;
						}
					}

				}else {
					System.out.println(url.getFile() + "Not a good outgoing link");
					
				}

			}

			System.out.println( "OutBound Links Score : " + outBoundLinksScore);

		} else {
			System.out.println("OutGoingLinkFactor is 0");
		}

		System.out.println();

	}

}
