package com.UST.Domains;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class DomainsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DomainsApplication.class, args);
    }

    @Bean
    public WebClient getWebClient() {
        return WebClient.builder().build();
    }    
}
