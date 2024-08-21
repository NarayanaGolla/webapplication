package com.core.application.httpclinet;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.time.Duration;

public class CustomHttpClientRequest {

    public static void main(String[] args) {
        try {
            // Create the HttpClient
            HttpClient client = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .connectTimeout(Duration.ofSeconds(10))
                    .build();

            // Create the HttpRequest
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://example.com/api/resource"))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer your-token-here")
                    .POST(HttpRequest.BodyPublishers.ofString("{\"name\": \"John\", \"age\": 30}"))
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Output the response
            System.out.println(response.statusCode());
            System.out.println(response.body());

            // Optionally, print the headers
            HttpHeaders headers = response.headers();
            headers.map().forEach((k, v) -> System.out.println(k + ":" + v));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
