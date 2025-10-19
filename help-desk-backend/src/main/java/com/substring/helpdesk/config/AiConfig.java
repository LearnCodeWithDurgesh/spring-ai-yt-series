package com.substring.helpdesk.config;

import org.slf4j.Logger;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.MessageWindowChatMemory;
import org.springframework.ai.chat.memory.repository.jdbc.JdbcChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    private Logger logger = org.slf4j.LoggerFactory.getLogger(AiConfig.class);

//
//    public JdbcChatMemoryRepository jdbcChatMemoryRepository(){
//        return JdbcChatMemoryRepository.builder()
//                .jdbcTemplate()
//                .jdbcTemplate()
//                .build();
//    }

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder, JdbcChatMemoryRepository jdbcChatMemoryRepository) {


        // chat memeory ko create kar sakte hai

        var chatMemory=MessageWindowChatMemory.builder()
                .chatMemoryRepository(jdbcChatMemoryRepository)
                .maxMessages(15)
                .build();


        logger.info("ChatClient bean created.");
        logger.info("chat memory bean created. {}", chatMemory.getClass().getName());
        return builder

                .defaultSystem("Summerize the response within 400 words.")
                .defaultAdvisors(new SimpleLoggerAdvisor(),
                        MessageChatMemoryAdvisor.builder(chatMemory).build()).build();
    }

}
