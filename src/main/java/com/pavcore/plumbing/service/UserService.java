package com.pavcore.plumbing.service;

import com.pavcore.plumbing.dto.requestTo.UserRequestTO;
import com.pavcore.plumbing.dto.responseTo.UserResponseTO;
import com.pavcore.plumbing.entiy.User;
import com.pavcore.plumbing.exception.EmailIsTakenException;
import com.pavcore.plumbing.exception.LoginIsTakenException;
import com.pavcore.plumbing.exception.UserRegistryException;
import com.pavcore.plumbing.mapper.UserMapper;
import com.pavcore.plumbing.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }

    public UserResponseTO getUser(long id) {
        User user = userRepo.getReferenceById(id);
        return userMapper.mapResp(user);
    }

    public List<UserResponseTO> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserResponseTO> userTOs = new ArrayList<>();
        for (User user : users) {
            userTOs.add(userMapper.mapResp(user));
        }
        return userTOs;
    }

    public UserResponseTO createUser(UserRequestTO userRequestTO) {
        if (findUserByLogin(userRequestTO.getLogin()) == null) {
            throw new UserRegistryException(userRequestTO.getLogin());
        }
        User user = userMapper.mapReq(userRequestTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepo.save(user);
        return userMapper.mapResp(user);
    }

    public void updateUserPassword(long id, String password) {
        User user = userRepo.getReferenceById(id);
        user.setPassword(passwordEncoder.encode(password));
    }

    public void updateUserLogin(long id, String login) {
        if (findUserByLogin(login) != null) {
            throw new LoginIsTakenException(login);
        }
        User user = userRepo.getReferenceById(id);
        user.setLogin(login);
    }

    public void updateUserEmail(long id, String email) {
        if (findUserByLogin(email) != null) {
            throw new EmailIsTakenException(email);
        }
        User user = userRepo.getReferenceById(id);
        user.setEmail(email);
    }

    public void deleteUser(long id) {
        User user = userRepo.getReferenceById(id);
        userRepo.deleteById(user.getId());
    }

    private User findUserByLogin(String login) {
        return userRepo.findByLogin(login)
                .orElse(null);
    }

    private User findUserByEmail(String email) {
        return userRepo.findByLogin(email)
                .orElse(null);
    }
}
