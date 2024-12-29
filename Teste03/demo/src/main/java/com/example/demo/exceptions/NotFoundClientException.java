package com.example.demo.exceptions;

public class NotFoundClientException extends RuntimeException {
    public NotFoundClientException(String message) {
        super(message);
    }
}
