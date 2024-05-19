package com.helios.service.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.helios.service.gateway.filters.AuthenticationFilter;



@Configuration
public class SpringCloudConfig {
	
	
	@Autowired
    AuthenticationFilter filter;
	
	static final String authApiUri = "lb://KRUNCH-AUTHSERVICE"; 
	static final String topicsSearchApiUri = "lb://KRUNCH-TOPICSSERVICE"; 
	
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
    	
    	
        return builder.routes()
                .route( r -> r.path("/authentication/login**")
                             .uri(authApiUri).id("AuthModule"))
                .route( r -> r.path("/v1/digitaltrends/topicsdata**")
                		.filters(f -> f.filter(filter))
                        .uri(topicsSearchApiUri).id("TopicSearchModule"))
                .route( r -> r.path("/v1/digitaltrends/topicentitysearch**")
                		.filters(f -> f.filter(filter))
                        .uri(topicsSearchApiUri).id("TopicSearchModule"))
                .route( r -> r.path("/authentication/register**")
                        .filters(f -> f.filter(filter))
                        .uri(authApiUri).id("AuthModule"))
                .build();
        
    }

}