package com.training.springboot.exception;

public class ServerException extends Exception {

    String message;
    public ServerException(String str) {
        message = str;
    }
    public String toString() {
        return ("Custom Exception Occurred : " + message);
    }
}
