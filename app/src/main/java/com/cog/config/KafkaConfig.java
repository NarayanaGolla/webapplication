package com.cog.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.ListTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.*;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Configuration
@EnableKafka
public class KafkaConfig {

    // Kafka Producer configuration
    private Map<String, Object> producerConfigs() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return configProps;
    }

    // Producer Factory Bean
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        return new DefaultKafkaProducerFactory<>(producerConfigs());
    }

    // Kafka Template Bean
    @Bean
    public KafkaTemplate<String, Object> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    // Kafka Consumer configuration
    private Map<String, Object> consumerConfigs() {
        Map<String, Object> configProps = new HashMap<>();
        configProps.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return configProps;
    }

    // Consumer Factory Bean
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    // AdminClient to manage Kafka topics
    @Bean
    public AdminClient adminClient() {
        Map<String, Object> configs = new HashMap<>();
        configs.put("bootstrap.servers", "localhost:9092");
        return AdminClient.create(configs);
    }

    // Check if a topic exists
    public boolean doesTopicExist(String topicName) throws ExecutionException, InterruptedException {
        try (AdminClient adminClient = AdminClient.create(adminClientProperties())) {
            ListTopicsResult topics = adminClient.listTopics();
            Set<String> existingTopics = topics.names().get();
            return existingTopics.contains(topicName);
        }
    }

    // Create a new topic if it doesn't exist
    public void createTopic(String topicName, int partitions, short replicationFactor) {
        try (AdminClient adminClient = AdminClient.create(adminClientProperties())) {
            if (!doesTopicExist(topicName)) {
                NewTopic newTopic = new NewTopic(topicName, partitions, replicationFactor);
                adminClient.createTopics(Collections.singletonList(newTopic)).all().get();
                System.out.println("Topic created: " + topicName);
            } else {
                System.out.println("Topic already exists: " + topicName);
            }
        } catch (ExecutionException | InterruptedException e) {
            System.err.println("Error while checking/creating topic: " + e.getMessage());
        }
    }

    @Bean
    public Properties adminClientProperties() {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "localhost:9092"); // Update with your Kafka broker URL
        return properties;
    }

    @Bean
    public void createTopic() {
        // Create a new topic named "test-topic"
        createTopic("csv-topic", 1, (short) 1);
    }
}
