package com.example.springai.demo_spring_ai.controller;

public record MyResponse(String generationTokens,
                         String promptTokens,
                         String totalTokens,
                         String content) {
}
