package com.mcp.app;

import com.mcp.app.config.Post;
import com.mcp.app.config.PostHttpService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@SpringBootTest
class McpAppApplicationTests {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WebClient webClient;

    @Autowired
    private PostHttpService postHttpService;

    @Autowired
    private RestClient restClient;

    @Test
    void testRestTemplateGet() {
        System.out.println("testing rest template");
        Post post = this.restTemplate.getForObject("https://jsonplaceholder.typicode.com/posts/8", Post.class);
        System.out.println(post);
        System.out.println(post.title());


    }

    @Test
    public void testRestTemplatePost() {

        var post = new Post(1, 1001001, "This is post title", "This is post body");
//        Post post1 = restTemplate.postForObject("https://jsonplaceholder.typicode.com/posts", post, Post.class);
//        System.out.println(post1);
//        System.out.println("post created successfully");

        var header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_JSON);
        //add more information as per need

        HttpEntity<Post> requestEntity = new HttpEntity<>(post, header);


        ResponseEntity<Post> postResponseEntity = restTemplate.postForEntity("https://jsonplaceholder.typicode.com/posts", requestEntity, Post.class);


        HttpStatusCode statusCode = postResponseEntity.getStatusCode();
        if (statusCode.is2xxSuccessful()) {
            System.out.println("post created successfully");
            System.out.println(postResponseEntity.getBody().title());
        } else {
            System.out.println("post creation failed");

        }
    }

    @Test
    public void testWebClient() throws InterruptedException {
        //get call for post
        Mono<Post> postMono = webClient
                .get()
                .uri("https://jsonplaceholder.typicode.com/posts/8")
                .retrieve()
                .bodyToMono(Post.class);

        postMono.subscribe((item) -> System.out.println(item.title()));


        System.out.println("post fetched successfully");

        Thread.sleep(5000);


    }


    @Test
    public void testWebClientPost() {

        var post = new Post(1, 1001001, "This is post title", "This is post body");
//

        var post1 = webClient.
                post()
                .uri("https://jsonplaceholder.typicode.com/posts")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(post)
                .retrieve()
                .bodyToMono(Post.class)
                .block();

        System.out.println("post created successfully");
        System.out.println(post1);
    }

    @Test
    public void testHttpExchange() {
//        Declarative

        Post post = postHttpService.getPost(1L);
        System.out.println(post.title());

        List<Post> allPosts = postHttpService.getAllPosts();
        System.out.println(allPosts.size());
    }

    @Test
    public void testRestClient() {
        Post body = restClient
                .get()
                .uri("https://jsonplaceholder.typicode.com/posts/8")
                .retrieve()
                .body(Post.class);
        System.out.println(body
        );
    }

}
