package com.spring.ai.firstproject.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {


    @Bean
    public ChatClient chatClient(ChatClient.Builder builder) {
        return builder
                .defaultSystem("You are a helpful coding assistant. You are an expert in coding.")
                .defaultOptions(OpenAiChatOptions.builder()
                        .model("gpt-4o-mini")
                        .temperature(0.3)
                        .maxTokens(200)
                        .build())
                .build();
    }


//
//    @Bean(name = "openAiChatClient")
//    public ChatClient openAiChatModel(OpenAiChatModel chatModel) {
//       return ChatClient.builder(chatModel).build();
//    }
//
//    @Bean(name = "ollamaChatClient")
//    public ChatClient ollamaChatModel(OllamaChatModel chatModel) {
//        return ChatClient.builder(chatModel).build();
//    }
//


}
