package com.example.springai.demo_spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimplePromptController {

    private final ChatClient chatClient;

    public SimplePromptController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("/simple")
    public  String simple(@RequestParam(defaultValue = "Tell me dada jokes") String userInput){
        return chatClient.prompt()
                .user(userInput)
                .call()
                .content();
    }
}
