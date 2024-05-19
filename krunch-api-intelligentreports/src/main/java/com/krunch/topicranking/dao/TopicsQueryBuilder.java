package com.krunch.topicranking.dao;

import java.util.HashMap;

public class TopicsQueryBuilder {
	
	HashMap<String,String> _hmQueryString = new HashMap<String,String>();
	HashMap<String,Double> _hmTopicRelevancyTolerance = new HashMap<String,Double>();
	HashMap<String,String> _hmTopicKeywords = new HashMap<String,String>();
	HashMap<String,String> _hmTopicKeyTitles = new HashMap<String,String>();
	HashMap<String,String> _hmTopicKeyOrganizations = new HashMap<String,String>();
	HashMap<String,String> _hmTopicKeyInfluencers = new HashMap<String,String>();
	
	
	
	public TopicsQueryBuilder() {
		
		this.init();
	}
	
	private void init() {
		
		_hmQueryString.put("digital", "digital");
		_hmQueryString.put("design", "Design");
		_hmQueryString.put("platform", "Platform|low-code|no-code|saas");
		_hmQueryString.put("api", "api&platform|api&development|api&security|api&integration|api&strategy|api&development|api&deplpoyment");
		_hmQueryString.put("ai", "artificial&intelligence|machine&learning|transfer&learning|deep&learning|natural&language&processing|NLP|reinforcement&learning|data&science");
		_hmQueryString.put("analytics", "(advanced|predictive|descriptive|realtime|prescriptive)&analytics\r\n" + 
				"data&engineering|big&data|advanced&analytics|data&mesh|data&analytics|real&time&streaming|graph&data|NoSQL|data&lake|data&visualization");
		_hmQueryString.put("cloud", "cloud&computing|multi&cloud|hybrid&cloud|aws|azure|gcp|cloud&native");
		_hmQueryString.put("devops", "devops|devsecops|sre|site&reliability|continuous&integration|continuous&delivery|continuous&deployment|software&delivery|Infrastructure&Code|chaos&engineering");
		_hmQueryString.put("cybersecurity", "cyber&security|data&security|cloud&security|application&security|NIST");
			_hmQueryString.put("container platform", "cncf|openshift|kubernetes|elastic&container|elastic&kubernetes|azure&kubernetes|fargate|docker");
		
		_hmQueryString.put("insurtech", "Insurtech|Insurance");
		_hmQueryString.put("banking", "Fintech|Banking|wealthtech|paytech|neobanking|regtech");
		_hmQueryString.put("lcnc", "low&code|No&Code|Low-Code");
		_hmQueryString.put("saas", "SAAS");
		_hmQueryString.put("wealth", "");
		_hmQueryString.put("regtech", "");
		_hmQueryString.put("agritech", "Agriculture|Agritech");
		_hmQueryString.put("healthcare", "Healthtech|Healthcare");
		_hmQueryString.put("cryptocurrency", "Cryptocurrency");
		_hmQueryString.put("education", "EdTech|Education");
		
		_hmQueryString.put("nft", "(NFT|NFTS|Fungible|Non-Fungible)&(platform|tokens|Asset|Strategy|investment|Collectibles|Defi|Market|Valuation|crypto|artwork|digital|security|hack|issues|fraud|ownership|blockchain)");
		_hmTopicRelevancyTolerance.put("nft", 0.60);
		_hmTopicKeywords.put("nft", "platform|nft|fungible|token|art|crypto|asset|invest|ethereum|blockchain|invest");
		_hmTopicKeyTitles.put("nft", "artist|founder|author|ceo|cto|entrepreneur");
		_hmTopicKeyInfluencers.put("nft", "Leon|winklemann|casey mcgrath|gary bracey|josh katz|charlie lee");
		_hmTopicKeyOrganizations.put("nft", "telegraph|ethereum|bloomberg|Goldman|Blackstone|Dapper|Beeple|coinbase|reuters");
		
		_hmQueryString.put("microservices", "Microservices|cloud&native|jwt|oauth|api&gateway|serverless|scalability|distributed&tracing|graphql|domain&driven&design|event&driven|service&discovery|CQRS|Event&Sourcing|SAGA|circuit&breaker");
		_hmTopicRelevancyTolerance.put("microservices", 0.75);
		_hmTopicKeywords.put("microservices", "Microservices|native|jwt|oauth|gateway|serverless|scalability|tracing|graphql|ddd|event&driven|discovery|CQRS|Event|SAGA|circuit");
		_hmTopicKeyTitles.put("microservices", "architect|developer|founder|author|ceo|cto|entrepreneur");
		_hmTopicKeyInfluencers.put("microservices", "fowler|Jitesh|Homsby");
		_hmTopicKeyOrganizations.put("microservices", "netflix|aws|azure|thoughtworks|kafka|Uber|spotify|github|Apache");

		_hmQueryString.put("banking", "Fintech|Banking|wealthtech|paytech|neobanking|regtech");
		_hmTopicRelevancyTolerance.put("banking", 1.0);
		_hmTopicKeywords.put("banking", "fintech|bank|wealthtech|payment|regulatory|customer|economy|investment|savings|fund|account|transaction|stock|forex|lending|saving|commerce|exchange|deposit");
		_hmTopicKeyTitles.put("banking", "architect|developer|founder|author|ceo|cto|entrepreneur|bank|analyst|investor|consumer");
		_hmTopicKeyInfluencers.put("banking", "dimon|horowitz|skinner|schulman|musk|monzo|brooks|levchin");
		_hmTopicKeyOrganizations.put("banking", "goldman|paypal|hsbc|mastercard|bankly|federal|suisse|canada|treasury");

		
		_hmQueryString.put("saas", "SAAS");
		_hmTopicRelevancyTolerance.put("saas", 0.60);
		_hmTopicKeywords.put("saas", "fintech|bank|wealthtech|payment|cloud|product|software|service");
		_hmTopicKeyTitles.put("saas", "architect|developer|founder|author|ceo|cto|entrepreneur|bank|analyst|investor|consumer");
		_hmTopicKeyInfluencers.put("saas", "benjamin||dharmesh|sandeep|hiten|jason|neil|noah|lincoln|david|aaron|claire|christoph|patrick|cancel|martell");
		_hmTopicKeyOrganizations.put("saas", "salesforce|aws|azure|hax|hubspot|proofhub|kissmetrics|crazyegg|echosign|sumo|servicenow|clarity|adp|adobe|docusign|cisco|twilio|atlassian|intuit|cornerstone");

		
		_hmQueryString.put("cancer screening", "  ");
		_hmQueryString.put("longread sequencing", "  ");
		_hmQueryString.put("gene therapy", "  ");
		_hmQueryString.put("3dprinting", "  ");
		_hmQueryString.put("orbital aerospace", "  ");
		_hmQueryString.put("delivery drones", "");
		_hmQueryString.put("autonomous ride", "  ");
		_hmQueryString.put("automation", "  ");
		_hmQueryString.put("bitcoin fundamentals", "  ");
		_hmQueryString.put("bitcoin company", "  ");
		_hmQueryString.put("electric vehicles", "  ");
		_hmQueryString.put("virtual worlds", "virtual&world|virtual&reality|augmented&reality|holograph|hologram|AR&Market|VR&Market");
		_hmQueryString.put("data center", "data&center|on-premise|hybrid&cloud|multi&cloud|nvidia|cisco|gpu|tpu|xeon|x86");
		_hmQueryString.put("deep learning", "Deep&Learning");
		
	
	}	
	
	public String getQueryforExecution(String topicType){
		
		return _hmQueryString.get(topicType);
		
	}
	
	public String getTopicKeyWords(String topicType){
		
		return  _hmTopicKeywords.get(topicType);
		
	}
	
public String getTopicKeyTitles(String topicType){
		
		return  _hmTopicKeyTitles.get(topicType);
		
	}

public String getTopicKeyInfluencers(String topicType){
	
	return  _hmTopicKeyInfluencers.get(topicType);
	
}

public String getTopicKeyOrgs(String topicType){
	
	return  _hmTopicKeyOrganizations.get(topicType);
	
}

public Double getTopicRelevancyToleranceLimit(String topicType){
		
		return _hmTopicRelevancyTolerance.get(topicType);
		
	}

	
}
