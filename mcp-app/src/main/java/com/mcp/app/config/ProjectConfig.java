package com.mcp.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.client.support.RestTemplateAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ProjectConfig {


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder().build();
    }

    @Bean
    public PostHttpService postHttpService() {

        var factory = HttpServiceProxyFactory.
                builderFor(RestTemplateAdapter.create(restTemplate()))
                .build();
        return factory.createClient(PostHttpService.class);
    }

//    create RestClient bean
    @Bean
    public RestClient restClient(){
        return RestClient.builder().build();
    }
}
