package com.blake.health.julio.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class HttpConfig
{
    @Bean
    public RestTemplate restController()
    {
        return new RestTemplate();
    }
}
