package com.helios.service.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.helios.service.gateway.filters.AuthenticationFilter;

//@Configuration
//@EnableConfigurationProperties(APIGatewayConfig.class)
public class GatewayRoutesConfiguration {
	
	//@Autowired
    //AuthenticationFilter filter;
	
	static final String authApiUri = "lb://KRUNCH-AUTHSERVICE"; 
	static final String topicsSearchApiUri = "lb://KRUNCH-TOPICSSERVICE"; 
	
	/*
	@Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route( r -> r.path("/authentication/login**")
                             .uri(authApiUri).id("AuthModule"))
                .route( r -> r.path("/v1/digitaltrends**")
                		.filters(f -> f.filter(filter))
                        .uri(topicsSearchApiUri).id("TopicSearchModule"))
                .route( r -> r.path("/authentication/register**")
                        .filters(f -> f.filt//er(filter))
                        .uri(authApiUri).id("AuthModule"))
                .build();
    }
	**/
	/*
	 @Bean
	  public RouteLocator proxyRouting(RouteLocatorBuilder builder, APIGatewayConfig consumerDestinations) {
	    return builder.routes()
	            .route(r -> r.path("/consumers").and().method("POST").uri(apiUri)
	            .route(r -> r.path("/consumers").and().method("PUT").uri(apiUri)
	            .build();
	  }
**/
}
