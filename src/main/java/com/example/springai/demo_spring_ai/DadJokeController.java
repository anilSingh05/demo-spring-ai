package com.example.springai.demo_spring_ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ai")
public class DadJokeController {

    private  final ChatClient chatClient;

    public DadJokeController(ChatClient.Builder chatClientBuilder){
        this.chatClient =  chatClientBuilder.build();
    }

    @GetMapping("/dadJokesOnly")
    public  String promptDadJokesOnly(@RequestParam(value = "inputMsg", defaultValue = "Tell me Dad Joke") String inputMsg){
        SystemMessage system = new SystemMessage("Your Primary function is to tell DadJokes Only. If someone asks you  for any other type  of jokes  please tell them you   only  know Dad  Jokes ");
        UserMessage userInput =  new UserMessage(inputMsg);
        Prompt prompt = new Prompt(List.of(system, userInput));

        return chatClient.prompt(prompt).call().content();
    }
}
