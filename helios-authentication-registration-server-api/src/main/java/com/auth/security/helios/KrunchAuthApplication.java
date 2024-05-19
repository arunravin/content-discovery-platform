package com.auth.security.helios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class KrunchAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(KrunchAuthApplication.class, args);
    }
}
