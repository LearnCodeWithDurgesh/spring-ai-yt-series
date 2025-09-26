package com.spring.ai.firstproject.controllers;

import com.spring.ai.firstproject.service.ChatService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping
public class ChatController {

    private ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam(value = "q", required = true) String q,
            @RequestHeader("userId") String userId
            ) {
        return ResponseEntity.ok(chatService.chatTemplate(q,userId));
    }


    @GetMapping("/stream-chat")
    public ResponseEntity<Flux<String>> streamChat(
            @RequestParam("q") String query
    ){
        return ResponseEntity.ok(this.chatService.streamChat(query));
    }




}
