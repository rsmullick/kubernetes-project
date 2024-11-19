package com.tutorial.spring.cloud.kubernetes.client;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ConfigurationProperties(prefix = "bean")
public class ClientConfig {
    private String message = "Message from backend is: %s <br/> Services : %s";
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
