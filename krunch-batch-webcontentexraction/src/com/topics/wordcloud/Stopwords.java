package com.topics.wordcloud;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class Stopwords {
	
	public static String[] stopwords = {"due","lot","avail","post","happen","tri","exampl","he","stop","agre","quit","true","describ","care","longer","side",
			"ten","greater","alon","feb","watch","novemb","septemb","street","love","didn","hear","due","miss","meanwhil","ill","eye","e","o",
			"obtain","wrong","june","prefer","bad","sit","respond","anti","nd","tie","fear","edit","item","..","front","wouldn",
			"mid","welcom","shot","otherwis","doubt","uncertaini","status","eas","f","p.m","lie","man","so-cal","fill","count","train","s","yfi",
			"ongo","joke","cheap","alongsid","i.e","ora","pre","pro","background","joe","adjust","mistake","normal","mike.","getti","evid",
			"closer","disclos","super","dog","di","mr","wasn","cool","fresh","titl","hire","room","food","alert","score","writer","box","ir",
			"ongo","met","actor","chosen","unabl","retain","delay","fals","minim","guy","cold","nobodi","voic","implic","modifi","born",
			"closer","disclos","super","dog","di","mr","wasn","cool","fresh","titl","hire","room","food","alert","score","writer","box","ir",
			"inu","poor","ignor","odd","charact","terror","distinct","provis","wit","somewher","arriv","earliest","io","t","quot","hidden",
			"outlin","fellow","extract","-2","default","grab","suspect","walk","weight","recognit","everybodi","ran","kick","destroy","sanc","wood","e.g","die",
			"twin","mari","al","panic","foot","pr","qr","greatest","floor","pros","blow","pow","tomorrow","heat","prone","combat",
			"shouldn","jone","east","crack","princip","burri","prison","peac","hurdl","passiv","ag","fool","dream","strike","tripl","pour","sonsol","lee",
			"honour","dude","abroad","reject","beauti","anim","fallen","anytim","older","speaker","tough","dalla","pledg","heat","drawn","combat",
			"mover","brad","uni","pitch","and/or","therbi","lure","crazi","an","alt","nick","scene","modest","keen","squeez","suspend","user-friend","hang",
			"set","file","case","organ","find","ago","complet","single","read","enabl","give","type","simpl","meet","identifi","mode","blog","discuss","articl",
			"high","start","day","pitch","move","result","end","center","everi","ensure","da","larg","today","control","specif","anoth","level","alreadi",
			"howev", "term", "plan", "limit", "understand", "open", "possibl", "thing", "number", "reason", "key", "peopl", "essential", "relat", "all", 
			"issue", "paa", "part", "function", "capabl", "sinc", "easili", "option", "back", "addit", "maintain", "wide", "usag", "popular", "advanc", "improv", 
			"gain", "great", "video", "real", "call", "current", "effect", "standard", "show", "opportun", "practic", "prof", "direct", "bring", "put", "save", 
			"physic", "size", "activ", "role", "concern", "choos", "remain", "cover", "critic", "local", "consid", "decis", "list", "price", "initi", "everyth", 
			"effort", "present", "execut", "individu", "player", "address", "check", "biggest", "full", "past", "month", "human", "similar", "exist", "util", "singl", 
			"question", "anywher", "interest", "handl", "ad", "abil", "doesn", "talk", "monitor", "associ", "turn", "state", "studi", "basic", "prepare", "sensit", 
			"defin", "live", "home", "hour", "track", "view", "posit", "actual", "built", "main", "word", "play", "ur", "choic", "colleg", "mention", 
			"pick", "mainten", "relationship", "denial", "topic", "fit", "smaller", "avoid", "buy", "piec", "guid", "typic", "clear", "compress", "strong", "involv", 
			"allow", "allows", "almost", "alone", "along", "already", "also", "although", "always", "am", "among", "amongst", "an", "and", "another", "any", 
			"anybody", "anyhow", "follow", "year", "anyway", "anyways", "anywhere", "apart", "appear", "appreciate", "appropriate", "are", "arent", "around", "as", "aside", "ask", "asking", "associated", "at", "available", "away", "awfully", "be", "became", "because", "become", "becomes", "becoming", "been", "before", "beforehand", "behind", "being", "believe", "below", "beside", "besides", "best", "better", "between", "beyond", "both", "brief", "but", "by", "cmon", "cs", "came", "can", "cant", "cannot", "cant", "cause", "causes", "certain", "certainly", "changes", "clearly", "co", "com", "come", "comes", "concerning", "consequently", "consider", "considering", "contain", "containing", "contains", "corresponding", "could", "couldnt", "course", "currently", "definitely", "described", "despite", "did", "didnt", "different", "do", "does", "doesnt", "doing", "dont", "done", "down", "downwards", "during", "each", "edu", "eg", "eight", "either", "else", "elsewhere", "enough", "entirely", "especially", "et", "etc", "even", "ever", "every", "everybody", "everyone", "everything", "everywhere", "ex", "exactly", "example", "except", "far", "few", "ff", "fifth", "first", "five", "followed", "following", "follows", "for", "former", "formerly", "forth", "four", "from", "further", "furthermore", "get", "gets", "getting", "given", "gives", "go", "goes", "going", "gone", "got", "gotten", "greetings", "had", "hadnt", "happens", "hardly", "has", "hasnt", "have", "havent", "having", "he", "hes", "hello", "help", "hence", "her", "here", "heres", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "hi", "him", "himself", "his", "hither", "hopefully", "how", "howbeit", "however", "i", "id", "ill", "im", "ive", "ie", "if", "ignored", "immediate", "in", "inasmuch", "inc", "indeed", "indicate", "indicated", "indicates", "inner", "insofar", "instead", "into", "inward", "is", "isnt", "it", "itd", "itll", "its", "its", "itself", "just", "keep", "keeps", "kept", "know", "knows", "known", "last", "lately", "later", "latter", "latterly", "least", "less", "lest", "let", "lets", "like", "liked", "likely", "little", "look", "looking", "looks", "ltd", "mainly", "many", "may", "maybe", "me", "mean", "meanwhile", "merely", "might", "more", "moreover", "most", "mostly", "much", "must", "my", "myself", "name", "namely", "nd", "near", "nearly", "necessary", "need", "needs", "neither", "never", "nevertheless", "new", "next", "nine", "no", "nobody", "non", "none", "noone", "nor", "normally", "not", "nothing", "novel", "now", "nowhere", "obviously", "of", "off", "often", "oh", "ok", "okay", "old", "on", "once", "one", "ones", "only", "onto", "or", "other", "others", "otherwise", "ought", "our", "ours", "ourselves", "out", "outside", "over", "overall", "own", "particular", "particularly", "per", "perhaps", "placed", "please", "plus", "possible", "presumably", "probably", "provides", "que", "quite", "qv", "rather", "rd", "re", "really", "reasonably", "regarding", "regardless", "regards", "relatively", "respectively", "right", "said", "same", "saw", "say", "saying", "says", "second", "secondly", "see", "seeing", "seem", "seemed", "seeming", "seems", "seen", "self", "selves", "sensible", "sent", "serious", "seriously", "seven", "several", "shall", "she", "should", "shouldnt", "since", "six", "so", "some", "somebody", "somehow", "someone", "something", "sometime", "sometimes", "somewhat", "somewhere", "soon", "sorry", "specified", "specify", "specifying", "still", "sub", "such", "sup", "sure", "ts", "take", "taken", "tell", "tends", "th", "than", "thank", "thanks", "thanx", "that", "thats", "thats", "the", "their", "theirs", "them", "themselves", "then", "thence", "there", "theres", "thereafter", "thereby", "therefore", "therein", "theres", "thereupon", "these", "they", "theyd", "theyll", "theyre", "theyve", "think", "third", "this", "thorough", "thoroughly", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "took", "toward", "towards", "tried", "tries", "truly", "try", "trying", "twice", "two", "un", "under", "unfortunately", "unless", "unlikely", "until", "unto", "up", "upon", "us", "use", "used", "useful", "uses", "using", "usually", "value", "various", "very", "via", "viz", "vs", "want", "wants", "was", "wasnt", "way", "we", "wed", "well", "were", "weve", "welcome", "well", "went", "were", "werent", "what", "whats", "whatever", "when", "whence", "whenever", "where", "wheres", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whos", "whoever", "whole", "whom", "whose", "why", "will", "willing", "wish", "with", "within", "without", "wont", "wonder", "would", "would", "wouldnt", "yes", "yet", "you", "youd", "youll", "youre", "youve", "your", "yours", "yourself", "yourselves", "zero"};
	public static Set<String> stopWordSet = new HashSet<String>(Arrays.asList(stopwords));
	public static Set<String> stemmedStopWordSet = stemStringSet(stopWordSet);
	
	public static boolean isStopword(String word) {
		if(word.length() < 2) return true;
		if(word.charAt(0) >= '0' && word.charAt(0) <= '9') return true; //remove numbers, "25th", etc
		if(stopWordSet.contains(word)) return true;
		else return false;
	}
	
	public static boolean isStemmedStopword(String word) {
		if(word.length() < 2) return true;
		if(word.charAt(0) >= '0' && word.charAt(0) <= '9') return true; //remove numbers, "25th", etc
		String stemmed = stemString(word);
		if(stopWordSet.contains(stemmed)) return true;
		if(stemmedStopWordSet.contains(stemmed)) return true;
		if(stopWordSet.contains(word)) return true;
		if(stemmedStopWordSet.contains(word)) return true;
		else return false;
	}
	
	public static String removeStopWords(String string) {
		String result = "";
		String[] words = string.split("\\s+");
		for(String word : words) {
			if(word.isEmpty()) continue;
			if(isStopword(string)) continue; //remove stopwords
			result += (word+" ");
		}
		return result;
	}
	
	public static String removeStemmedStopWords(String string) {
		String result = "";
		String[] words = string.split("\\s+");
		for(String word : words) {
			if(word.isEmpty()) continue;
			if(isStemmedStopword(word)) continue;
			if(word.charAt(0) >= '0' && word.charAt(0) <= '9') continue; //remove numbers, "25th", etc
			result += (word+" ");
		}
		return result;
	}
	
	public static String stemString(String string) {
		return new Stemmer().stem(string);
	}
	
	public static Set<String> stemStringSet(Set<String> stringSet) {
		Stemmer stemmer = new Stemmer();
		Set<String> results = new HashSet<String>();
		for(String string : stringSet) {
			results.add(stemmer.stem(string));
		}
		return results;
	}
}
