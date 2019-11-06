package com.lukaszbezlada.controller;

import com.lukaszbezlada.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestClass {

    private UserDao userDao;

    @Autowired
    public TestClass(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("/showUser")
    public String showUser() {
        System.out.println(userDao.getUser(1L).toString());
        return "account";
    }
}
