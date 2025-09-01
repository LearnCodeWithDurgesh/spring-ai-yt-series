package com.spring.ai.firstproject.service;

import com.spring.ai.firstproject.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @Override
    public List<Tut> chat(String query) {

//        call the llm for response
//        String content = chatClient
//                .prompt()
//                .user(prompt)R
//                .system("As as expert in cricket.")
//                .call()
//                .content();

//        String prompt = "tell me about virat kohli?";=
        Prompt prompt1 = new Prompt(query);

        List<Tut> tutorials =chatClient
                .prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tut>>() {
                });


        return tutorials;
    }


}
