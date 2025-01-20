package com.cog.controller;


import com.cog.kafka.KafkaProducer;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/kafka")
public class KafkaController {


    private KafkaProducer kafkaProducer;


    @Autowired
    private KafkaController(KafkaProducer kafkaProducer , HttpSession session) {
       this.kafkaProducer= kafkaProducer;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam(defaultValue = "Guest" , required = false) String message) {
        kafkaProducer.sendMessage(message);
        return "Message sent to Kafka!";
    }
}

