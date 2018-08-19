package com.spring.data.service;

import com.spring.data.entity.User;
import com.spring.data.repository.UserRepository;
import com.spring.data.util.HMAC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * Created by mint on 8/19/18.
 */

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public User findOneByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }

    public void create(String username, String password, String realName, String email) {
        final Date now = new Date();
        User user = new User();
        user.setUsername(username);
        user.setSalt(UUID.randomUUID().toString());
        String encryptedPassword = HMAC.hash(user.getSalt(), password);
        user.setPasswordHash(encryptedPassword);
        user.setRealName(realName);
        user.setEmail(email);
        user.setCreateTime(now);
        user.setCreateBy("user");
        userRepository.save(user);
    }
}
