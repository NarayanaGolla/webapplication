package com.cog.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducer {

    private static final String TOPIC = "test_topic";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, Object>> future =   kafkaTemplate.send(TOPIC, message);
        future.whenComplete( (result , ex) -> {
                 if(ex == null) {
                     System.out.println("Send Message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");

                 } else {
                     System.out.println("Unable to Send Message=["+ message + "] due to : " + ex.getMessage());

                 }

        });
    }
}

