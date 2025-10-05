package com.spring.ai.firstproject.service;

import reactor.core.publisher.Flux;

import java.util.List;

public interface ChatService {


    String getResponse(String userQuery);


    void saveData(List<String> list);

}
