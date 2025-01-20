package com.cog.controller;

import com.cog.jwt.JwtResponse;
import com.cog.jwt.JwtUtil;
import com.cog.jwt.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/userlogin")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Validate the user (e.g., check username and password)
        String username = loginRequest.getUsername();
        String password = loginRequest.getPassword();

        if ("user".equals(username) && "password".equals(password)) { // Replace with real validation
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(new JwtResponse(token));
        } else {
            return ResponseEntity.status(401).body("Invalid username or password");
        }
    }


}
