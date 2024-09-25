package com.pavcore.plumbing.service;

import com.pavcore.plumbing.dao.postgres.entity.User;
import com.pavcore.plumbing.dto.requestTo.UserRequestTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthService {

    private final SecretKey secretKey = Keys.hmacShaKeyFor("jopa-kabana".getBytes());
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    public ResponseEntity<Map<String, String>> login(UserRequestTO userRequestTO) {
        if (isValidUser(userRequestTO)) {
            String token = Jwts.builder()
                    .subject(userRequestTO.getLogin())
                    .claim("role", "USER_ROLE")
                    .issuedAt(new Date())
                    .expiration(new Date(System.currentTimeMillis() + 86400000))
                    .signWith(secretKey)
                    .compact();
            Map<String, String> response = new HashMap<>();
            response.put("token", token);
            return ResponseEntity.ok(response);
        } else return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    private boolean isValidUser(UserRequestTO userRequestTO) {
        User user = userService.findUserByLogin(userRequestTO.getLogin());
        return passwordEncoder.encode(userRequestTO.getPassword()).equals(user.getPassword())
                && userRequestTO.getLogin().equals(user.getLogin())
                && userRequestTO.getEmail().equals(user.getEmail());
    }
}
