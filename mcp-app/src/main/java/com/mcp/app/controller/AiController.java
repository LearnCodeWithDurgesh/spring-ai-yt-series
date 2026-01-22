package com.mcp.app.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {

    private ChatClient chatClient;
    public AiController(ChatClient.Builder chatClientBuilder, ToolCallbackProvider toolCallbackProvider) {
        this.chatClient = chatClientBuilder
                .defaultToolCallbacks(toolCallbackProvider)
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }


    //localhost:8081/ai/chat?query=hello

    @PostMapping("/chat")
    public ResponseEntity<String> getAiResponse(
            @RequestParam("query") String query
    ) {
        String resposne = chatClient.prompt(query).call().content();
        return ResponseEntity.ok(resposne);
    }

    @PostMapping("/groq")
    public ResponseEntity<String> getResponseFromGroq(@RequestParam("query") String query) {
        return ResponseEntity.ok(chatClient.prompt(query).call().content());
    }
}
