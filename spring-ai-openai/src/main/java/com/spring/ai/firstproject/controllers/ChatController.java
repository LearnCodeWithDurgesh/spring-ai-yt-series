package com.spring.ai.firstproject.controllers;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ChatController {


    private ChatClient openAiChatClient;

    private ChatClient ollamaChatClient;

    public ChatController(@Qualifier("openAiChatClient") ChatClient openAiChatClient, @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
        this.openAiChatClient = openAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }


    //    public ChatController(OpenAiChatModel openAiChatModel   , OllamaChatModel ollamaChatModel) {
//

    /// /        System.out.println(chatModel.getClass().getName());
    /// /
    /// /        this.chatClient = ChatClient.builder(chatModel).build();
//
//        this.openAiChatClient=ChatClient.builder(openAiChatModel).build();
//        this.ollamaChatClient=ChatClient.builder(ollamaChatModel).build();
//
    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam(value = "q", required = true) String q) {
        var resultResponse = this.ollamaChatClient
                .prompt(q)
                .call()
                .content();



        return ResponseEntity.ok(resultResponse);
    }

}
