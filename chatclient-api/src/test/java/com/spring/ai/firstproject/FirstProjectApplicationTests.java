package com.spring.ai.firstproject;

import com.spring.ai.firstproject.service.ChatService;
import com.spring.ai.firstproject.service.ChatServiceImpl;
import org.junit.jupiter.api.Test;

import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class FirstProjectApplicationTests {


	@Test
	void contextLoads() {



		var promptTemplate = PromptTemplate.builder()
				.resource(null)
				.build();
		var rendered=promptTemplate.render(Map.of("var1","This is var1 value"));
		System.out.println(rendered);



	}


	@Autowired
	private ChatService chatService;
	@Test
	void testTemplateRender(){

		System.out.println("Template Renderer");

		var output=this.chatService.chatTemplate();
		System.out.println(output);

	}


}
