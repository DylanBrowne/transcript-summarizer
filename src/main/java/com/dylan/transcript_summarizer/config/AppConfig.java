package com.dylan.transcript_summarizer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// This configuration class is responsible for defining beans that will be managed by the Spring container.
@Configuration
public class AppConfig {

    // This method defines a RestTemplate bean, which is used to make HTTP requests to external APIs.
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
