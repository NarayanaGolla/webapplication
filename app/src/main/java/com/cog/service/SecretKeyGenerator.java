package com.cog.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {
    public static void main(String[] args) {
//        SecureRandom secureRandom = new SecureRandom();
//        byte[] secretKey = new byte[32];  // 256-bit key
//        secureRandom.nextBytes(secretKey);
//        String encodedKey = Base64.getEncoder().encodeToString(secretKey);
//        System.out.println("Generated Secret Key: " + encodedKey);


        generateToken("Narayana");

    }


    // Generate a random 256-bit secret
    private static String generateRandomSecret() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretBytes = new byte[32]; // 256 bits
        secureRandom.nextBytes(secretBytes);
        return Base64.getEncoder().encodeToString(secretBytes);
    }

    private final static  String secret = "my-secret-key";  // This should ideally be a longer and more random key

    // Method to generate JWT token
    public static String generateToken(String username) {

        String randomSecret = generateRandomSecret();

        // Convert the secret into a SecretKey
        SecretKey key = Keys.hmacShaKeyFor(randomSecret.getBytes());


        // Generate the JWT token
        return Jwts.builder()
                .setSubject(username)
                .signWith(key, SignatureAlgorithm.HS256)  // Use HMAC SHA-256 algorithm for signing
                .compact();
    }
}