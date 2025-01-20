package com.cog.controller;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.common.errors.TopicExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ExecutionException;

@Service
public class KafkaTopicService {

    private final AdminClient adminClient;

    @Autowired
    public KafkaTopicService(AdminClient adminClient) {
        this.adminClient = adminClient;
    }

    // Check if a topic exists
    public boolean doesTopicExist(String topicName) throws ExecutionException, InterruptedException {
        ListTopicsResult topics = adminClient.listTopics();
        Set<String> existingTopics = topics.names().get();
        return existingTopics.contains(topicName);  // Return true if topic exists
    }

    // Create a new topic if it doesn't exist
    public void createTopic(String topicName, int partitions, short replicationFactor) {
        try {
            // Check if the topic exists
            if (!doesTopicExist(topicName)) {
                NewTopic newTopic = new NewTopic(topicName, partitions, replicationFactor);
                adminClient.createTopics(java.util.Collections.singletonList(newTopic));
                System.out.println("Topic created: " + topicName);
            } else {
                System.out.println("Topic already exists: " + topicName);
            }
        } catch (ExecutionException | InterruptedException e) {
            // Handle exceptions (e.g., Kafka connection issues)
            System.err.println("Error while checking/creating topic: " + e.getMessage());
        }
    }
}

