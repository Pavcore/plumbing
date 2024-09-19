package com.pavcore.plumbing.exception;

public class EmailIsTakenException extends RuntimeException {
    public EmailIsTakenException(String message) {
        super(message);
    }
}
