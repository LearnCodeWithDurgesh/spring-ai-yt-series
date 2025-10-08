package com.lcwd.tool.calling.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class WeatherTool {


    private RestClient restClient;

    public WeatherTool(RestClient restClient) {
        this.restClient = restClient;
    }

    @Value("${app.weather.api-key}")
    private String weatherApiKey;

    @Tool(description = "Get weather information of given city.")
    public String getWeather(@ToolParam(description = "city of which we want to get weather information") String city) {
        // external api use karni to get the current weather information

        //RestTemplate, RestClient
        System.out.println("get weather information of given city.");

        var response = restClient.
                get()
                .uri(
                        builder -> builder.path("/current.json")
                                .queryParam("key", weatherApiKey)
                                .queryParam("q", city)
                                .build()
                )
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String,Object>>() {
                });

        return response.toString();


    }

}
