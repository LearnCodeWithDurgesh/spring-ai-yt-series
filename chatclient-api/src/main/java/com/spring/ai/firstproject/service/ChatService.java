package com.spring.ai.firstproject.service;

import com.spring.ai.firstproject.entity.Tut;

import java.util.List;

public interface ChatService {

    List<Tut> chat(String query);

}
