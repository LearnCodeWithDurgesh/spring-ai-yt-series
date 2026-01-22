package com.gemini.app.controllers;

import com.gemini.app.services.AiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AiController {


    private  final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @GetMapping
    public ResponseEntity<String> getResposneFromAI(
            @RequestParam String query
    ){
        String response = aiService.getResponseFromAI(query);
        return ResponseEntity.ok(response);
    }
}
