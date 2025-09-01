package com.spring.ai.firstproject.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {


    @Bean(name = "openAiChatClient")
    public ChatClient openAiChatModel(OpenAiChatModel chatModel) {
       return ChatClient.builder(chatModel).build();
    }

    @Bean(name = "ollamaChatClient")
    public ChatClient ollamaChatModel(OllamaChatModel chatModel) {
        return ChatClient.builder(chatModel).build();
    }





}
