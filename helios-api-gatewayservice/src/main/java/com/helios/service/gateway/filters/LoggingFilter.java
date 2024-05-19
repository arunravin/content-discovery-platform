package com.helios.service.gateway.filters;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;
import java.util.Set;

import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ORIGINAL_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_REQUEST_URL_ATTR;
import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR;

@Component
@Order(3)
public class LoggingFilter implements GlobalFilter {
	Log log = LogFactory.getLog(getClass());

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		
		Set<URI> uris = exchange.getAttributeOrDefault(GATEWAY_ORIGINAL_REQUEST_URL_ATTR, Collections.emptySet());
		String originalUri = (uris.isEmpty()) ? "Unknown" : uris.iterator().next().toString();
		Route route = exchange.getAttribute(GATEWAY_ROUTE_ATTR);
		URI routeUri = exchange.getAttribute(GATEWAY_REQUEST_URL_ATTR);
		
		log.info("Incoming request " + originalUri + "from "+
					exchange.getRequest().getRemoteAddress()
				+ " is routed to id: " + route.getId() + ", uri:" + routeUri);
		
		  HttpHeaders headers = exchange.getRequest().getHeaders();
	        Set<String> headerNames = headers.keySet(); 
	        StringBuffer strHeader = new StringBuffer();
	        		
	        headerNames.forEach((header) -> {
	         	strHeader.append( header  + ":" + headers.get(header)).append(" # ");
	        });
	        
	        log.info(  "Request Headers : " + strHeader);
	        
	       
		
	        return chain.filter(exchange);
	}
}