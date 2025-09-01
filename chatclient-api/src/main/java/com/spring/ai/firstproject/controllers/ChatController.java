package com.spring.ai.firstproject.controllers;

import com.spring.ai.firstproject.entity.Tut;
import com.spring.ai.firstproject.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class ChatController {


//    private  ChatClient chatClient;

    private ChatService chatService;

//    private ChatClient openAiChatClient;
//
//    private ChatClient ollamaChatClient;

//    public ChatController(@Qualifier("openAiChatClient") ChatClient openAiChatClient, @Qualifier("ollamaChatClient") ChatClient ollamaChatClient) {
//        this.openAiChatClient = openAiChatClient;
//        this.ollamaChatClient = ollamaChatClient;
//    }

//    public ChatController(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.build();
//    }

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
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
    public ResponseEntity<List<Tut>> chat(
            @RequestParam(value = "q", required = true) String q) {

        return ResponseEntity.ok(chatService.chat(q));
    }



}
