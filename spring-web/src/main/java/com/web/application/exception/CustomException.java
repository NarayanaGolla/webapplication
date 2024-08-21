package com.training.springboot.exception;

public class CustomException extends Exception {

    String message;
    public CustomException(String str) {
        message = str;
    }
    public String toString() {
        return ("Custom Exception Occurred : " + message);
    }
}
