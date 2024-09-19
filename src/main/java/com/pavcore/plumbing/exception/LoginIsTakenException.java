package com.pavcore.plumbing.exception;

public class LoginIsTakenException extends RuntimeException {
    public LoginIsTakenException(String message) {
        super(message);
    }
}
