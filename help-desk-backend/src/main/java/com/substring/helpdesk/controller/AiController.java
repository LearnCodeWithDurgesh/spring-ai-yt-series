package com.substring.helpdesk.controller;

import com.substring.helpdesk.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AiController {


    private  final AIService service;

    @PostMapping
    public ResponseEntity<String >  getResponse(@RequestBody  String query){
        return ResponseEntity.ok(service.getResponseFromAssistant(query));
    }

}
