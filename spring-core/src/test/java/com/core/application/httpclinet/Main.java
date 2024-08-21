package com.core.application.httpclinet;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Main {
    public static void main(String[] args) {

        try {

            HttpClient client = HttpClient.newBuilder().build();

            // Create a custom HTTP request
            CustomHttpRequest customRequest = CustomHttpRequest.newBuilder()
                    .uri("https://example.com/api/resource")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer your-token-here")
                    .method("POST", HttpRequest.BodyPublishers.ofString("{\"name\": \"John\", \"age\": 30}"))
                    .timeout(Duration.ofSeconds(10))
                    .build();


            // Send the custom request
            HttpResponse<String> response = client.send(customRequest.getHttpRequest(), HttpResponse.BodyHandlers.ofString());

            // Output the response
            System.out.println(response.statusCode());
            System.out.println(response.body());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
