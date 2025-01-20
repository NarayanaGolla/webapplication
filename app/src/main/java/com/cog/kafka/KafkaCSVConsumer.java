package com.cog.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class KafkaCSVConsumer {

    private static final String TOPIC = "csv-topic";

    @KafkaListener(topics = TOPIC, groupId = "csv-group")
    public void consumeCSVData(String message) {
        // Split the CSV row into individual fields
        String[] fields = message.split(",");

        // Process the fields (e.g., print or store in a database)
        System.out.println("Received row: " + Arrays.toString(fields));
    }
}
