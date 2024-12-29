package com.example.demo.dto;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;

@Getter
public class ExceptionDTO {
    private String message;
    private String method;
    private String path;
    private String status;
    private LocalDateTime timestamp;

    public ExceptionDTO(String message, HttpStatus status, HttpServletRequest request) {
        this.message = message;
        this.method = request.getMethod();
        this.path = request.getRequestURI();
        this.status = status.toString();
        this.timestamp = LocalDateTime.now();
    }
    
}
