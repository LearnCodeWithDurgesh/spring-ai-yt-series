package com.substring.helpdesk.service;

import com.substring.helpdesk.tools.EmailTool;
import com.substring.helpdesk.tools.TicketDatabaseTool;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Getter
@Setter
public class AIService {

    private final ChatClient chatClient;

    private final TicketDatabaseTool ticketDatabaseTool;
    private final EmailTool emailTool;

    @Value("classpath:/helpdesk-system.st")
    private Resource systemPromptResource;

    public String getResponseFromAssistant(String query, String conversationId) {

        //basic call to llm
        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                //tool informations
                .tools(ticketDatabaseTool, emailTool)
                .system(systemPromptResource)
                .user(query)
                .call()
                .content();


    }

    public Flux<String> streamResponseFromAssistant(String query, String conversationId) {


        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec.param(ChatMemory.CONVERSATION_ID, conversationId))
                //tool informations
                .tools(ticketDatabaseTool, emailTool)
                .system(systemPromptResource)
                .user(query)
                .stream().content();

    }


}
