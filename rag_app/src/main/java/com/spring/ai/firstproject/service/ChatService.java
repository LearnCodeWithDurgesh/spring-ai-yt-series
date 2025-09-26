package com.spring.ai.firstproject.service;

import reactor.core.publisher.Flux;

import java.util.List;

public interface ChatService {

    String chatTemplate(String query, String userId);


    Flux<String> streamChat(String query);

    void saveData(List<String> list);

}
