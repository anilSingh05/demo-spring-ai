package com.example.springai.demo_spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/youTube")
public class YouTubeCoontroller {

    private  final ChatClient chatClient;

    public YouTubeCoontroller(ChatClient.Builder chatClient){
        this.chatClient = chatClient.build();
    }

    @GetMapping("/popular")
    public String findPopularYouTuberByGenre(@RequestParam(value = "genre", defaultValue = "tech")String genre){
        String message = """
                 List 10 of the most popular YouTuber in {genre} along with their current  subscriber counts.  If you
                 don't know the answer. Just say "I don't know!",
                 """;
        PromptTemplate promptTemplate = new PromptTemplate(message);
        Prompt prompt = promptTemplate.create(Map.of("genre", genre));


        return chatClient.prompt(prompt).call().content();
    }

}
