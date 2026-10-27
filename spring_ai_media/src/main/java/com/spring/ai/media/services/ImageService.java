package com.spring.ai.media.services;

import org.apache.logging.log4j.util.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@Service
public class ImageService {

    private final ImageModel imageModel;

    private final Logger logger = LoggerFactory.getLogger(ImageService.class);

    public ImageService(ImageModel imageModel) {
        this.imageModel = imageModel;
    }

    public String generateImage(String prompt) throws IOException {


        OpenAiImageOptions imageOptions = OpenAiImageOptions.builder()
                .N(1)
                .model("gpt-image-1")
                .quality("low")
                .height(1024)
                .width(1024)


                .build();

        logger.info("image options {}", imageOptions);


        ImageResponse imageResponse = imageModel.call(new ImagePrompt(
                prompt,
                imageOptions

        ));
        logger.info("image response {}", imageResponse);
        logger.info("image generations {}", imageResponse.getResult());


        convertAndWrite(imageResponse.getResult().getOutput().getB64Json());


        return "Image generated";

    }

    public String uploadToCloud(String b64_json){
        //logic to upload image to cloud//
        return "url";
    }

    void convertAndWrite(String b64_json) throws IOException {

        byte[] decode = Base64.getDecoder().decode(b64_json);
        Files.write(Paths.get("image.png"), decode);
        logger.info("file saved success");

    }

}
