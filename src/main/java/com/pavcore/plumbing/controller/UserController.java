package com.pavcore.plumbing.controller;

import com.pavcore.plumbing.dto.requestTo.UserRequestTO;
import com.pavcore.plumbing.dto.responseTo.UserResponseTO;
import com.pavcore.plumbing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public UserResponseTO getUser(@PathVariable long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public List<UserResponseTO> getUsers() {
        return userService.getAllUsers();
    }

    @PostMapping()
    public UserResponseTO createUser(@RequestBody UserRequestTO userRequestTO) {
        return userService.createUser(userRequestTO);
    }

    @PutMapping("/password")
    public ResponseEntity<String> updatePassword(@RequestParam String password) {
        userService.updateUserPassword(1, password);
        return new ResponseEntity<>("Password updated", HttpStatus.OK);
    }

    @PutMapping("/login")
    public ResponseEntity<String> updateLogin(@RequestParam String login) {
        userService.updateUserLogin(1, login);
        return new ResponseEntity<>("Login updated", HttpStatus.OK);
    }

    @PutMapping("/email")
    public ResponseEntity<String> updateEmail(@RequestParam String email) {
        userService.updateUserEmail(1, email);
        return new ResponseEntity<>("Email updated", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>("User delete", HttpStatus.OK);
    }
}
