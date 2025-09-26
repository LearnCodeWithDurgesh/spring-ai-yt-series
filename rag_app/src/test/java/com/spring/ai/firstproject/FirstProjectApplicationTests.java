package com.spring.ai.firstproject;

import com.spring.ai.firstproject.helper.Helper;
import com.spring.ai.firstproject.service.ChatService;
import com.spring.ai.firstproject.service.ChatServiceImpl;
import org.junit.jupiter.api.Test;

import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class FirstProjectApplicationTests {


    @Autowired
    private  ChatService chatService;
    @Test
    void saveDataToVectorDatabase(){
        System.out.println("saving data to database");
        this.chatService.saveData(Helper.getData());
        System.out.println("data is saved successfully");
    }

}
