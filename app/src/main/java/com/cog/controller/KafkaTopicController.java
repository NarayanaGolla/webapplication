package com.cog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/kafka")
public class KafkaTopicController {

    private final KafkaTopicService kafkaTopicService;

    @Autowired
    public KafkaTopicController(KafkaTopicService kafkaTopicService) {
        this.kafkaTopicService = kafkaTopicService;
    }

    // API to create topic if it doesn't exist
    @PostMapping("/create-topic")
    public String createTopic(@RequestParam String topicName,
                              @RequestParam int partitions,
                              @RequestParam short replicationFactor) {
        kafkaTopicService.createTopic(topicName, partitions, replicationFactor);
        return "Topic checked and created if it didn't exist.";
    }

    // API to check if a topic exists
    @GetMapping("/topic-exists")
    public boolean doesTopicExist(@RequestParam String topicName) throws ExecutionException, InterruptedException, ExecutionException {
        return kafkaTopicService.doesTopicExist(topicName);
    }
}

