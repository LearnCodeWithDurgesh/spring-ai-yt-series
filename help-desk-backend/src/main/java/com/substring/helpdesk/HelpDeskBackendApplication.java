package com.substring.helpdesk;



import org.apache.logging.log4j.message.ThreadDumpMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication

public class HelpDeskBackendApplication {

	public static void main(String[] args) throws InterruptedException {
	SpringApplication.run(HelpDeskBackendApplication.class, args);



    }

}
