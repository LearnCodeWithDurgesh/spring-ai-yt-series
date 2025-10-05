package com.spring.ai.firstproject;

import com.spring.ai.firstproject.helper.Helper;
import com.spring.ai.firstproject.service.ChatService;
import com.spring.ai.firstproject.service.ChatServiceImpl;
import com.spring.ai.firstproject.service.DataLoader;
import com.spring.ai.firstproject.service.DataTransformer;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Test;

import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.reader.JsonReader;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;

@SpringBootTest
class FirstProjectApplicationTests {


    @Autowired
    private DataLoader dataLoader;

    @Autowired
    private DataTransformer dataTransformer;

    @Autowired
    private VectorStore vectorStore;

    @Test
    void testDataLoader() {
        var documents = dataLoader.loadDocumentsFromJson();
        IO.println(documents.size());

        documents.forEach(item -> {
            IO.println(item);
        });


    }

    @Test
    void testPdfDataLoader() {
        List<Document> documents = this.dataLoader.loadDocumentsFromPdf();
        System.out.println(documents.size());
        documents.forEach(item -> {
            System.out.println(item);
            System.out.println("__________________-");
        });

        IO.println("Read__now going to transform");

        var transformedDocument = this.dataTransformer.transform(documents);
        System.out.println(transformedDocument.size());

//        going to save the data into database

        this.vectorStore.add(transformedDocument);
        System.out.println("Done");


    }


}
