package com.jgdev.timework.TimeWork.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

public class ExceptionsdDetails {
    private String title;
    private LocalDateTime timestamp;
    private String exception;
    private Map<String, String> details;
    private HttpStatus status;

    public ExceptionsdDetails(String title, LocalDateTime timestamp, String exception, Map<String, String> details, HttpStatus status) {
        this.title = title;
        this.timestamp = timestamp;
        this.exception = exception;
        this.details = details;
        this.status = status;
    }
}
