package com.cog.jwt;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    // Generate JWT Token
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    private String createToken(Map<String, Object> claims, String subject) {
        // Create SecretKey from the secret key string (you can also use Keys.secretKeyFor() for random keys)
        String randomSecret = generateRandomSecret();
        SecretKey key = Keys.hmacShaKeyFor(randomSecret.getBytes());

        return Jwts.builder()
                .setClaims(claims) // Custom claims
                .setSubject(subject) // User identifier
                .setIssuedAt(new Date(System.currentTimeMillis())) // Current time
                .setExpiration(new Date(System.currentTimeMillis() + expiration)) // Expiration time
                .signWith(key, SignatureAlgorithm.HS256) // Sign using the generated SecretKey
                .compact();
    }

    // Generate a random 256-bit secret
    private static String generateRandomSecret() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] secretBytes = new byte[32]; // 256 bits
        secureRandom.nextBytes(secretBytes);
        return Base64.getEncoder().encodeToString(secretBytes);
    }
}
