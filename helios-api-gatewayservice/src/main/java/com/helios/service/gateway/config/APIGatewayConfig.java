package com.helios.service.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties(prefix = "app.*")
public class APIGatewayConfig {

  @NotNull
  private String authserviceurl;
  
  @NotNull
  private String jwtsecret;

	public String getAuthserviceurl() {
		return authserviceurl;
	}
	
	public void setAuthserviceurl(String authserviceurl) {
		this.authserviceurl = authserviceurl;
	}
	
	public String getJwtsecret() {
		return jwtsecret;
	}
	
	public void setJwtsecret(String jwtsecret) {
		this.jwtsecret = jwtsecret;
	}

 
}
