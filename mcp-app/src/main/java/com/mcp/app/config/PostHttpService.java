package com.mcp.app.config;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.List;

@HttpExchange(url = "https://jsonplaceholder.typicode.com")
public interface PostHttpService {


    //    get post
    @GetExchange("/posts/{id}")
    Post getPost(@PathVariable Long id);

    //    post post

    @PostExchange("/posts")
    Post createPost(@RequestBody Post post);

    @GetExchange("/posts")
    List<Post> getAllPosts();


}
