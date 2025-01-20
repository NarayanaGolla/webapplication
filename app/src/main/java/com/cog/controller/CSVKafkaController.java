package com.cog.controller;

import com.cog.kafka.KafkaCSVProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;

@RestController
@RequestMapping("/kafka")
public class CSVKafkaController {

    @Autowired
    private KafkaCSVProducer kafkaCSVProducer;

    @PostMapping("/upload-csv")
    public String uploadCSV(@RequestParam("file") MultipartFile file) throws Exception {
        // Save the file locally
        File csvFile = new File(System.getProperty("java.io.tmpdir") + "/" + file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(csvFile)) {
            fos.write(file.getBytes());
        }

        // Send the CSV data to Kafka
        kafkaCSVProducer.sendCSVData(csvFile.getAbsolutePath());

        return "CSV data sent to Kafka topic successfully!";
    }
}
