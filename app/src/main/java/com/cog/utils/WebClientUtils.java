package com.cog.utils;

import com.cog.dom.User;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class WebClientUtils {

    public static String get(String url , String token) {

        // Create a WebClient instance
        WebClient client = WebClient.builder()
                .baseUrl(url)
                .defaultHeader("Authorization", "Bearer " + token)  // Adding default Authorization header
                .build();

         String response = client.get()
                .retrieve()
                .bodyToMono(String.class)
                .block();
        return response;
    }

    public static String post(String url , String endpoint , String requestBody) {

        WebClient client = WebClient.create(url);
        String response = null;

        // Define the payload to be sent in the POST request
       // String requestBody = "{\"key\":\"value\"}";

        try {
            // Sending the POST request
            response = client.post()
                    .uri(endpoint) // Specify the URI if needed
                    .header("Content-Type", "application/json") // Set the content type header if sending JSON
                    .body(Mono.just(requestBody), String.class) // Attach the body
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // Print the response
            System.out.println(response);
        } catch (WebClientResponseException e) {
            // Handle exceptions
            System.err.println("Error response: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }

    public void createReactiveWebClient() {
        WebClient client = WebClient.create("http://localhost:8080");

        // Retrieving a Single Resource
        // To retrieve a single resource of type Mono from endpoint /employee/{id}:

        Mono<User> employeeMono = client.get()
                .uri("/employees/{id}", "1")
                .retrieve()
                .bodyToMono(User.class);

        employeeMono.subscribe(System.out::println);


        // Retrieving a Collection Resource
        //  to retrieve a collection resource of type Flux from endpoint /employees:

        Flux<User> employeeFlux = client.get()
                .uri("/employees")
                .retrieve()
                .bodyToFlux(User.class);

        employeeFlux.subscribe(System.out::println);




    }
}
