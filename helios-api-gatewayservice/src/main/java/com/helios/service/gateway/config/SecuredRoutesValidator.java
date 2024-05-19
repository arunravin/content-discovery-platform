package com.helios.service.gateway.config;

import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class SecuredRoutesValidator {

    public static final List<String> openApiEndpoints = List.of(
            "/authentication1/login",
            "/authentication1/register",
            "/authentication1/pingService",
            "/v1/digitaltrends1/topicsdata"
    );

    public Predicate<ServerHttpRequest> isSecured =
            request -> openApiEndpoints
                    .stream()
                    .noneMatch(uri -> request.getURI().getPath().contains(uri));

}