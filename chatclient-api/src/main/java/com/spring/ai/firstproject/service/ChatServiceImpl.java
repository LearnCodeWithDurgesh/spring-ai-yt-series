package com.spring.ai.firstproject.service;

import com.spring.ai.firstproject.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public String chat(String query) {

//        call the llm for response
//        String content = chatClient
//                .prompt()
//                .user(prompt)R
//                .system("As as expert in cricket.")
//                .call()
//                .content();

//        String prompt = "tell me about virat kohli?";=
//        Prompt prompt1 = new Prompt(query, OpenAiChatOptions.builder()
//                .model("gpt-4o-mini")
//                .temperature(0.3)
//                .maxTokens(100)
//                .build());

        Prompt prompt = new Prompt(query);
        //modify this prompt and extra things to prompt make it more interactive
        String queryStr = "As an expert in coding and programing. Always write program in java . Now reply for this question :{query}";


//        prompt template
//        prompt
//        get prompt template from resources.....
        var tutorials = chatClient
                .prompt()
                .user(u -> u.text(queryStr).param("query",queryStr))
                .call()
                .content();
        return tutorials;
    }


}
