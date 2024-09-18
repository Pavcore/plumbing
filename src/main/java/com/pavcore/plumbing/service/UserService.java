package com.pavcore.plumbing.service;

import com.pavcore.plumbing.dto.requestTo.UserRequestTO;
import com.pavcore.plumbing.dto.responseTo.UserResponseTO;
import com.pavcore.plumbing.entiy.User;
import com.pavcore.plumbing.exception.LoginOrEmailIsTakenException;
import com.pavcore.plumbing.exception.UserNotFoundException;
import com.pavcore.plumbing.exception.UserRegistryException;
import com.pavcore.plumbing.mapper.UserMapper;
import com.pavcore.plumbing.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

    public UserResponseTO getUser(String login) {
        User user = findUserByLogin(login);
        if (user == null) {
            throw new UserNotFoundException(login);
        }
        return userMapper.mapResp(user);
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

    //todo jsession or jwt
    public UserResponseTO updateUser(UserRequestTO userRequestTO) {
        if (findUserByLogin(userRequestTO.getLogin()) != null || findUserByEmail(userRequestTO.getEmail()) != null) {
            throw new LoginOrEmailIsTakenException(userRequestTO.getLogin() + " : " + userRequestTO.getEmail());
        }

        return null;
    }

    public void deleteUser(String login) {
        User user = findUserByLogin(login);
        if (user == null) {
            throw new UserNotFoundException(login);
        }
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
