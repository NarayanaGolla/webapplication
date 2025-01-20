package com.cog.controller;

import com.cog.dom.User;
import com.cog.service.JsonFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController_bkp {

    @Autowired
    private JsonFileService jsonFileService;

    @GetMapping
    public List<User> getAllUsers() throws IOException {
        return jsonFileService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) throws IOException {
        return jsonFileService.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) throws IOException {
        jsonFileService.addUser(user);
    }

    @PutMapping("/{id}")
    public void updateUser(@PathVariable int id, @RequestBody User user) throws IOException {
        jsonFileService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) throws IOException {
        jsonFileService.deleteUser(id);
    }
}

