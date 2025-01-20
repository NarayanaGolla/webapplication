package com.cog.service;

import com.cog.dom.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class JsonFileService {
    private final String filePath = "./app/src/main/resources/data.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<User> getAllUsers() throws IOException {
        return objectMapper.readValue(new File(filePath), new TypeReference<List<User>>() {});
    }

    public User getUserById(int id) throws IOException {
        return getAllUsers().stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addUser(User newUser) throws IOException {
        List<User> users = getAllUsers();
        users.add(newUser);
        objectMapper.writeValue(new File(filePath), users);
    }

    public void updateUser(int id, User updatedUser) throws IOException {
        List<User> users = getAllUsers();
        for (User user : users) {
            if (user.getId() == id) {
                user.setUsername(updatedUser.getUsername());
                break;
            }
        }
        objectMapper.writeValue(new File(filePath), users);
    }

    public void deleteUser(int id) throws IOException {
        List<User> users = getAllUsers();
        users.removeIf(user -> user.getId() == id);
        objectMapper.writeValue(new File(filePath), users);
    }
}

