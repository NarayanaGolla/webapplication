package com.cog.kafka;
import com.cog.utils.CSVUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KafkaCSVProducer {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "csv-topic";

    public void sendCSVData(String filePath) throws Exception {
        List<String[]> rows = CSVUtil.readCSV(filePath);

        for (String[] row : rows) {
            String message = String.join(",", row); // Convert each row to a comma-separated string
            kafkaTemplate.send(TOPIC, message);    // Send the message to the Kafka topic
        }
    }
}

