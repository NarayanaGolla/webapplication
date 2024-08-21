package com.training.springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private int statusCode;
    private String message;
    private String details;
    private LocalDateTime timestamp;

    public ErrorDetails(LocalDateTime now, String message, String description) {
        timestamp = now;
        this.message = message;
        this.details = description;
    }
}
