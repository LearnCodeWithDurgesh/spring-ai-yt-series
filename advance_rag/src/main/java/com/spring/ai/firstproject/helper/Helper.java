package com.spring.ai.firstproject.helper;

import java.util.List;

public class Helper {


    public static List<String> getData(){
        return List.of("Java is a platform-independent, object-oriented programming language.",
                "JVM converts Java bytecode into machine code at runtime.",
                "JDK includes the compiler (javac) and JVM tools.",
                "Java supports garbage collection to manage memory automatically.",
                "A class is a blueprint, while an object is an instance of that class.",
                "public static void main(String[] args) is the entry point of a Java program.",
                "Java supports multi-threading using the Thread class or Runnable interface.",
                "synchronized keyword ensures thread safety.",
                "Spring Boot simplifies Java backend development with auto-configuration.",
                "Hibernate ORM maps Java objects to database tables.",
                "JPA is a specification; Hibernate is an implementation.",
                "Java 8 introduced Lambda expressions and Streams API.",
                "The Optional class avoids null pointer exceptions.",
                "In Spring, @Autowired injects dependencies automatically.",
                "Spring Security handles authentication and authorization.",
                "Spring Data JPA provides repository interfaces for database queries.",
                "Microservices in Spring Boot often use Eureka for service discovery.",
                "Spring Cloud Config provides centralized configuration.",
                "Spring Boot applications typically run on an embedded Tomcat server.",
                "REST APIs in Java use @RestController and @RequestMapping.");
    }

}
