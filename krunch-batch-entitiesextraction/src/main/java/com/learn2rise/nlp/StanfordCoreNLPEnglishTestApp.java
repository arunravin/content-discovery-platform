package com.learn2rise.nlp;

import java.io.IOException;

import edu.stanford.nlp.pipeline.StanfordCoreNLP;

/** app for testing if Maven distribution is working properly */

public class StanfordCoreNLPEnglishTestApp {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("Main...");
		String[] englishArgs = new String[] { "-file", "sample-english.txt", "-outputFormat", "text", "-props",
				"english.properties" };
		StanfordCoreNLP.main(englishArgs);
		System.out.println("Executed...");
	}
}
