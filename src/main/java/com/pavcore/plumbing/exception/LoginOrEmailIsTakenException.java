package com.pavcore.plumbing.exception;

public class LoginOrEmailIsTakenException extends RuntimeException {
    public LoginOrEmailIsTakenException(String message) {
        super(message);
    }
}
