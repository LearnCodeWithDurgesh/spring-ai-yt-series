package com.lcwd.tool.calling.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class AiConfig {



    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {

        return builder.defaultAdvisors(new SimpleLoggerAdvisor()).build();
    }


    @Bean
    public RestClient restClient(){
        return RestClient
                .builder()
                .baseUrl("http://api.weatherapi.com/v1")
                .build();
    }

}
