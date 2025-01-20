package com.cog.kafka;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.Config;
import org.apache.kafka.clients.admin.ConfigEntry;
import org.apache.kafka.clients.admin.DescribeConfigsResult;
import org.apache.kafka.common.config.ConfigResource;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

public class KafkaVersionChecker {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        try (AdminClient adminClient = AdminClient.create(props)) {
            ConfigResource resource = new ConfigResource(ConfigResource.Type.BROKER, "0");
            DescribeConfigsResult describeConfigsResult = adminClient.describeConfigs(Collections.singleton(resource));
            Map<ConfigResource, Config> config = describeConfigsResult.all().get();
            Config brokerConfig = config.get(resource);
            for (ConfigEntry entry : brokerConfig.entries()) {
                if (entry.name().equals("inter.broker.protocol.version")) {
                    System.out.println("Kafka Broker Version: " + entry.value());
                }
            }
        }
    }
}
