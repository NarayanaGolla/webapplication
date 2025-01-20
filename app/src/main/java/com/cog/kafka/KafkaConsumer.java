package com.cog.kafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "test_topic", groupId = "1")
    public void consume(String message) {
        System.out.println("Consumed message: " + message);
    }
}

