package com.bp.exception;

import java.time.LocalDate;
import java.util.List;

public class ErrorDetails {
    private LocalDate timestamp;
    private String message;
    private List<String> errors;

    public ErrorDetails(LocalDate timestamp, String message) {
        this.timestamp = timestamp;
        this.message = message;
    }

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

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
