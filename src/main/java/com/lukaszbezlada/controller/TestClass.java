package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;


@Controller
public class TestClass {

    private UserRepository userRepository;

    @Autowired
    public TestClass(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/showUser")
    public String showUser() {
        System.out.println(userRepository.findById(1L).toString());
        Optional<User> user = userRepository.findById(1L);
        user.ifPresent(value -> value.setLogin("jjjjj"));
        user.ifPresent(value -> userRepository.save(value));
        System.out.println(userRepository.findById(1L).toString());
        return "account";
    }
}
