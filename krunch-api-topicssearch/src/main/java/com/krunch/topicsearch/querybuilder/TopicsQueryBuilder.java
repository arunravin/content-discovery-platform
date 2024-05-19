package com.krunch.topicsearch.querybuilder;

import java.util.HashMap;

public class TopicsQueryBuilder {
	
	HashMap<String,String> _hmQueryString = new HashMap<String,String>();
	
	
	public TopicsQueryBuilder() {
		
		this.init();
	}
	
	private void init() {
		
		//order by topicrnk desc
	
		_hmQueryString.put("business", "select * from \"VW_BusinessTech_Topic_Data\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("digital", "select * from \"VW_Digital_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("design", "select * from \"VW_Design_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("platform", "select * from \"VW_Platform_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("api", "select * from \"VW_API_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("applications", "select * from \"VW_Data_CloudNativeApp_Topic_Data\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("gamechangers", "select * from \"VW_Venture_Fortune_Unicorn_Billions_Topic_Data\" order by topicrnk desc");
		_hmQueryString.put("ai", "select * from \"VW_AIML_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("analytics", "select * from \"VW_Data_Analytics_Topic_Data\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("cloud", "select * from \"VW_PublicCloud_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("leaders", "select * from \"VW_TechLeader_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("techinvest", "select * from \"VW_TechInvesment_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("devops", "select * from \"VW_DevOps_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("cybersecurity", "select * from \"VW_CyberSecurity_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("microservices", "select * from \"VW_Microservices_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("fullstack", "select * from \"VW_Fullstack_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("container platform", "select * from \"VW_KubernetesOpenShift_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		
		_hmQueryString.put("insurtech", "select * from \"VW_InsurTech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("insurtechdesc", "select * from \"VW_InsurTech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("banking", "select * from \"VW_Banking_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("bankingdesc", "select * from \"VW_Banking_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc ");
		
		_hmQueryString.put("lcnc", "select * from \"VW_LCNC_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("lcncdesc", "select * from \"VW_LCNC_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("saas", "select * from \"VW_SAAS_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("saasdesc", "select * from \"VW_SAAS_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		
		_hmQueryString.put("wealth", "select * from \"VW_Wealth_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("wealthdesc", "select * from \"VW_Wealth_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		_hmQueryString.put("regtech", "select * from \"VW_Regtech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("regtechdesc", "select * from \"VW_Regtech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		_hmQueryString.put("agritech", "select * from \"VW_Agritech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("agritechdesc", "select * from \"VW_Agritech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		_hmQueryString.put("healthcare", "select * from \"VW_Healthtech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("healthcaredesc", "select * from \"VW_Healthtech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		_hmQueryString.put("cryptocurrency", "select * from \"VW_CryptoCurrency_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc ");
		_hmQueryString.put("cryptocurrencydesc", "select * from \"VW_CryptoCurrency_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc ");
		_hmQueryString.put("education", "select * from \"VW_Edtech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("educationdesc", "select * from \"VW_Edtech_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		
		_hmQueryString.put("fullstackdesc", "select * from \"VW_Fullstack_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("microservicesdesc", "select * from \"VW_Microservices_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("devopsdesc", "select * from \"VW_DevOps_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc ");
		_hmQueryString.put("businessdesc", "select * from \"VW_BusinessTech_Topic_Data\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("designdesc", "select * from \"VW_Design_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("platformdesc", "select * from \"VW_Platform_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("apidesc", "select * from \"VW_API_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("digitaldesc", "select * from \"VW_Digital_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("applicationsdesc", "select * from \"VW_Data_CloudNativeApp_Topic_Data\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("gamechangersdesc", "select * from \"VW_Venture_Fortune_Unicorn_Billions_Topic_Data\" ");
		_hmQueryString.put("aidesc", "select * from \"VW_AIML_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("analyticsdesc", "select * from \"VW_Data_Analytics_Topic_Data\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("clouddesc", "select * from \"VW_PublicCloud_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("leadersdesc", "select * from \"VW_TechLeader_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("techinvestdesc", "select * from \"VW_TechInvesment_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("devopsdesc", "select * from \"VW_DevOps_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("cybersecuritydesc", "select * from \"VW_CyberSecurity_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");
		_hmQueryString.put("container platformdesc", "select * from \"VW_KubernetesOpenShift_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");

		
		_hmQueryString.put("cancer screening", "select * from \"VW_MultiCancerScreening_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("cancer screeningdesc", "select * from \"VW_MultiCancerScreening_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		
		_hmQueryString.put("longread sequencing", "select * from \"VW_LongReadSequencing_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("longread sequencingdesc", "select * from \"VW_LongReadSequencing_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		
		_hmQueryString.put("gene therapy", "select * from \"VW_GeneCellTherapy_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("gene therapydesc", "select * from \"VW_GeneCellTherapy_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		
		_hmQueryString.put("3dprinting", "select * from \"VW_3DPrinting_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("3dprintingdesc", "select * from \"VW_3DPrinting_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
	
		_hmQueryString.put("orbital aerospace", "select * from \"VW_OrbitalAerospace_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("orbital aerospacedesc", "select * from \"VW_OrbitalAerospace_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		
		_hmQueryString.put("delivery drones", "select * from \"VW_DeliveryDrones_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("delivery dronesdesc", "select * from \"VW_DeliveryDrones_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		
		_hmQueryString.put("autonomous ride", "select * from \"VW_AutonomousDrive_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("autonomous ridedesc", "select * from \"VW_AutonomousDrive_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		
		_hmQueryString.put("automation", "select * from \"VW_Automation_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("automationdesc", "select * from \"VW_Automation_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
		
		_hmQueryString.put("bitcoin fundamentals", "select * from \"VW_BitcoinFundamentals_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("bitcoin fundamentalsdesc", "select * from \"VW_BitcoinFundamentals_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
	 
		_hmQueryString.put("bitcoin company", "select * from \"VW_BitcoinInstituitions_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("bitcoin companydesc", "select * from \"VW_BitcoinInstituitions_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
	 
		_hmQueryString.put("smart contract", "select * from \"VW_SmartContract_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("smart contractdesc", "select * from \"VW_SmartContract_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
	 
		
		_hmQueryString.put("electric vehicles", "select * from \"VW_ElectricVehicles_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("electric vehiclesdesc", "select * from \"VW_ElectricVehicles_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
	 

		_hmQueryString.put("virtual worlds", "select * from \"VW_VirtualWorlds_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("virtual worldsdesc", "select * from \"VW_VirtualWorlds_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
	 
		_hmQueryString.put("data center", "select * from \"VW_DataCenterReinvention_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("data centerdesc", "select * from \"VW_DataCenterReinvention_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
	 
		_hmQueryString.put("deep learning", "select * from \"VW_DeepLearning_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("deep learningdesc", "select * from \"VW_DeepLearning_News\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc limit 500");
	 
		
		_hmQueryString.put("videos", "select * from \"VW_Events_Youtube_Podcasts\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by topicrnk desc");
		_hmQueryString.put("videosdesc", "select * from \"VW_Events_Youtube_Podcasts\"  where  \"CreatedAt\" > CURRENT_TIMESTAMP - INTERVAL '5 months' order by \"CreatedAt\" desc");

	}	
	
	public String getQueryforExecution(String topicType){
		
		return _hmQueryString.get(topicType);
		
	}

	
}
