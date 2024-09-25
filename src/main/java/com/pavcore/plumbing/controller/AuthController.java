package com.pavcore.plumbing.controller;

import com.pavcore.plumbing.dto.requestTo.UserRequestTO;
import com.pavcore.plumbing.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> login(@RequestBody UserRequestTO userRequestTO) {
        return authService.login(userRequestTO);
    }
}
