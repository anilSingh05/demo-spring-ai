package com.example.springai.demo_spring_ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.image.ImageModel;
import org.springframework.ai.openai.audio.speech.SpeechModel;

import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringAiController {
    private final ChatClient chatClient;
    private final SpeechModel speechModel;
    private final ImageModel imageModel;
    private final VectorStore vectorStore;


    // Constructor to initialize the ChatClient, SpeechModel, ImageModel, and VectorStore.
    public SpringAiController(ChatClient.Builder builder, SpeechModel speechModel, ImageModel imageModel, VectorStore vectorStore) {

        this.chatClient = builder.build();
        this.speechModel = speechModel;
        this.imageModel = imageModel;

        this.vectorStore = vectorStore;
    }



    // This class can be used to define common endpoints or configurations for the Spring AI application.
    // Currently, it does not contain any specific methods or mappings.
    // You can add methods here to handle requests related to Spring AI functionalities.
    // For example, you could define endpoints for AI model interactions, data processing, etc.
    // If you need to implement specific functionalities, you can create additional controllers or services
    
    // Write Get methods here to handle requests from AI chat clients or other components.
    @GetMapping("/string")
    public String getstring(@RequestParam(defaultValue = "What is the meaning of Life!") String userInput) {
        // This method can be used to process the user input and return a ChatResponse.
        // You can implement the logic to interact with AI models or services here.
        // For now, it returns a default response.
        return chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }

    @GetMapping("/response")
    public ChatResponse getResponse(@RequestParam(defaultValue = "What is the meaning of Life!") String userInput) {
        // This method can be used to process the user input and return a ChatResponse.
        // You can implement the logic to interact with AI models or services here.
        // For now, it returns a default response.
        return chatClient.prompt()
                .user(userInput)
                .call()
                .chatResponse();
    }

    @GetMapping("/entity")
    public MyResponse getEntity(@RequestParam(defaultValue = "What is the meaning of Life!") String userInput) {
        // This method can be used to process the user input and return a ChatResponse.
        // You can implement the logic to interact with AI models or services here.
        // For now, it returns a default response.
        return chatClient.prompt()
                .user(userInput)
                .call()
                .entity(MyResponse.class);
    }

    @GetMapping("/rag")
    public String getResponseFromOurData(@RequestParam(defaultValue = "What is the meaning of Life!") String userInput) {
        // This method can be used to process the user input and return a ChatResponse.
        // You can implement the logic to interact with AI models or services here.
        // For now, it returns a default response.
        return chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }
}
