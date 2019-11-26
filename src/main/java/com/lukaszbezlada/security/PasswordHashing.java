package com.lukaszbezlada.security;

import com.lukaszbezlada.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordHashing {

    private PasswordEncoder passwordEncoder;

    @Autowired
    public PasswordHashing(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public void passwordHashing(User user) {
        String passwordHash = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordHash);
    }
}
