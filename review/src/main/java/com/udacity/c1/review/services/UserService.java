package com.udacity.c1.review.services;

import com.udacity.c1.review.mapper.UserMapper;
import com.udacity.c1.review.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;
@Service
public class UserService {
    private HashService hashService;
    private UserMapper userMapper;

    public UserService(HashService hashService, UserMapper userMapper) {
        this.hashService = hashService;
        this.userMapper = userMapper;
    }

    public int createUser(User user){
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        return userMapper.createUser(new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstname(), user.getLastname()));
    }

    public Boolean isUsernameAvailable(String username){
        User user = userMapper.getUser(username);
        return user == null;
    }
}
