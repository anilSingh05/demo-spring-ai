package com.example.springai.demo_spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/youTube")
public class YouTubeController {

    private  final ChatClient chatClient;

    @Value("classpath:/prompts/youTube.st")
    private Resource ytPromptResource;

    public YouTubeController(ChatClient.Builder chatClient){
        this.chatClient = chatClient.build();
    }

    @GetMapping("/popular")
    public String findPopularYouTuberByGenre(@RequestParam(value = "genre", defaultValue = "tech")String genre){
        PromptTemplate promptTemplate = new PromptTemplate(ytPromptResource);
        Prompt prompt = promptTemplate.create(Map.of("genre", genre));


        return chatClient.prompt(prompt).call().content();
    }

}
