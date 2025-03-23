package com.cog.service;

import com.cog.dao.UserRepository;
import com.cog.dom.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private UserRepository repository;

    public List<User> getAllEmployees() {
        return repository.findAll();
    }
}
