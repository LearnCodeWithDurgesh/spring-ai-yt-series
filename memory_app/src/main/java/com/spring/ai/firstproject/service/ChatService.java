package com.spring.ai.firstproject.service;

import reactor.core.publisher.Flux;

public interface ChatService {

    String chatTemplate(String query, String userId);


    Flux<String> streamChat(String query);

}
