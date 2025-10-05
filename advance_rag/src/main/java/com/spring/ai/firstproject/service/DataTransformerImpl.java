package com.spring.ai.firstproject.service;

import org.springframework.ai.document.Document;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataTransformerImpl implements DataTransformer {
    @Override
    public List<Document> transform(List<Document> documents) {
        var splitter = new TokenTextSplitter(300,400,10,5000,true);
        return splitter.transform(documents);
    }
}
