package com.cog.controller;


import com.cog.service.AsyncService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    private final AsyncService asyncService;

    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @GetMapping("/start-tasks")
    public String startTasks() {
        for (int i = 1; i <= 10; i++) {
            asyncService.executeTask("Task-" + i);
        }
        return "Tasks started!";
    }
}

