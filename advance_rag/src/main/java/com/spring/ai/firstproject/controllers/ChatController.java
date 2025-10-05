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


    @PostMapping("/chat")
    public ResponseEntity<String> getResponse(@RequestParam("q") String userQuery){
        return ResponseEntity.ok(chatService.getResponse(userQuery));
    }





}
