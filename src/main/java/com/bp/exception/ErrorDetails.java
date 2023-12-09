package com.bp.exception;

import java.time.LocalDate;
import java.util.List;

public class ErrorDetails {
    private LocalDate timestamp;
    private String message;
    private List<String> errors;

    // Constructor with only timestamp and message
    public ErrorDetails(LocalDate timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

    // Constructor with timestamp, message, and errors
    public ErrorDetails(LocalDate timestamp, String message, List<String> errors) {
        this.timestamp = timestamp;
        this.message = message;
        this.errors = errors;
    }

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public List<String> getErrors() {
        return errors;
    }

    // Add a setter method for errors
    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
