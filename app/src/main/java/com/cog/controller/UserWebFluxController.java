package com.cog.controller;

import com.cog.dom.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserWebFluxController {


    @GetMapping("/{id}")
    public Mono<User> getEmployeeById(@PathVariable String id) {
        return null;
    }

    @GetMapping
    public Flux<User> getAllEmployees() {
        return null;
    }


    @PostMapping("/update")
    @PreAuthorize("hasRole('ADMIN')")
    public Mono<User> updateEmployee(@RequestBody User user) {
        return null;
    }
}
