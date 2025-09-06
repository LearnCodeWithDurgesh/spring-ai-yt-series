package com.spring.ai.firstproject.service;

import com.spring.ai.firstproject.entity.Tut;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.chat.prompt.SystemPromptTemplate;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {

    private ChatClient chatClient;


    @Value("classpath:/prompts/user-message.st")
    private Resource userMessage;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemMessage;

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
                .user(u -> u.text(queryStr).param("query", queryStr))
                .call()
                .content();
        return tutorials;
    }


    public String chatTemplate() {


        //first step
//        PromptTemplate strTemplate = PromptTemplate.builder().template("What is {techName}? tell ma also about {techExample}").build();
//
//        //render the template
//
//        String renderedMessage = strTemplate.render(Map.of(
//                "techName", "Spring",
//                "techExample", "spring exception"
//        ));
//
//
//        Prompt prompt = new Prompt(renderedMessage);

//
//        var systemPromptTemplate=SystemPromptTemplate.builder()
//                .template("You are a helpful coding assistant. You are an expert in coding.")
//                .build();
//        var systemMessage=systemPromptTemplate.createMessage();
//
//        var userPromptTemplate=PromptTemplate.builder().template("What is {techName}? tell ma also about {techExample}").build();
//        var userMessage=userPromptTemplate.createMessage(Map.of(
//                "techName", "Spring",
//                "techExample", "spring exception"
//        ));


//        Prompt prompt = new Prompt(systemMessage,userMessage);


        return this.chatClient
                .prompt()
                .system(system ->
                        system.text(this.systemMessage))
                .user(user ->
                        user.text(this.userMessage).param("concept", "Python iteration"))
                .call()
                .content()
                ;
    }
}
