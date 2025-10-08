package com.lcwd.tool.calling;

import com.lcwd.tool.calling.tools.WeatherTool;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ToolCallingExampleApplicationTests {


    private @Autowired WeatherTool weatherTool;


    @Test
    void getWeatherTest() {
        var response = weatherTool.getWeather("Delhi India");
        System.out.println(response);
    }

}
