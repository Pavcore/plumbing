package com.pavcore.plumbing.controller;

import com.pavcore.plumbing.dto.requestTo.UserInfoRequestTO;
import com.pavcore.plumbing.dto.responseTo.UserInfoResponseTO;
import com.pavcore.plumbing.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user_info")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @Autowired
    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @GetMapping("/{id}")
    public UserInfoResponseTO getUserInfoService(@PathVariable long id) {
        return userInfoService.getUserInfo(id);
    }

    @PostMapping
    public UserInfoResponseTO createUserInfo(@RequestBody UserInfoRequestTO userInfoRequestTO) {
        return userInfoService.createUserInfo(userInfoRequestTO);
    }

    @PutMapping("/first_name/{id}")
    public ResponseEntity<String> updateUserInfoFirstName(@RequestParam String firstName,
                                                          @PathVariable long id) {
        userInfoService.updateUserInfoFirstName(id, firstName);
        return new ResponseEntity<>("Name updated", HttpStatus.OK);
    }

    @PutMapping("/last_name/{id}")
    public ResponseEntity<String> updateUserInfoLastName(@RequestParam String lastName,
                                                         @PathVariable long id) {
        userInfoService.updateUserInfoLastName(id, lastName);
        return new ResponseEntity<>("Surname updated", HttpStatus.OK);
    }

    @PutMapping("/phone/{id}")
    public ResponseEntity<String> updateUserInfoPhone(@RequestParam int phone,
                                                      @PathVariable long id) {
        userInfoService.updateUserInfoPhone(id, phone);
        return new ResponseEntity<>("Phone updated", HttpStatus.OK);
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<String> updateUserInfoAddress(@RequestParam String address,
                                                        @PathVariable long id) {
        userInfoService.updateUserInfoAddress(id, address);
        return new ResponseEntity<>("Address updated", HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteUserInfo(@RequestParam long id) {
        userInfoService.deleteUserInfo(id);
        return new ResponseEntity<>("User information deleted", HttpStatus.OK);
    }
}
