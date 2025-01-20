package com.cog.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async("taskExecutor")
    public void executeTask(String taskName) {
        System.out.println(Thread.currentThread().getName() + " is executing task: " + taskName);
        try {
            Thread.sleep(2000); // Simulate task processing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished task: " + taskName);
    }
}
