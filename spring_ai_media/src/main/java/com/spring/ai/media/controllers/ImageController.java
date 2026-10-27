package com.spring.ai.media.controllers;


import com.spring.ai.media.services.ImageService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.image.ImageModel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/images")
public class ImageController {


    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    //    images generate

    @PostMapping
    public String generate(
            @RequestParam("prompt") String prompt
    ) throws IOException {
        return imageService.generateImage(prompt);

    }

}
