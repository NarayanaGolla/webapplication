package com.cog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${msg:Config Server is not working. Please check...}")
    private String msg;

    @Value("${spring.profiles.active}")
    private String activeProfile;


    private Environment environment;

    @Autowired
    public ProfileController(Environment environment) {
        this.environment = environment;
    }

    @GetMapping("/active-profile")
    @PreAuthorize("hasRole('ADMIN')")
    public String getActiveProfile1() {
        return String.join(", ", environment.getActiveProfiles());
    }
}
