package com.cog.jwt;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class TokenConsumer {

    public static void main(String[] args) {
        String token = "your-generated-token";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/api/secure-data", String.class, entity);

        System.out.println(response.getBody());
    }
}
