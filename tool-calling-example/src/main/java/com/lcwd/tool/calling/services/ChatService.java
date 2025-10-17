package com.lcwd.tool.calling.services;

import com.lcwd.tool.calling.tools.SimpleDateTimeTool;
import com.lcwd.tool.calling.tools.WeatherTool;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private ChatClient chatClient;
    private WeatherTool weatherTool;

    public ChatService(ChatClient chatClient, WeatherTool weatherTool) {
        this.chatClient = chatClient;
        this.weatherTool = weatherTool;
    }


    // chat method::: get response from llm model
    //chatClient:: client for calling llm model
    // tool description : chatbot for tool calling
    public String chat(String q) {
        return chatClient
                .prompt()
                .tools(new SimpleDateTimeTool(), weatherTool)
                .user(q)
                .call()
                .content();
    }

}
