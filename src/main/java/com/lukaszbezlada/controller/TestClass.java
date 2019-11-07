package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
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
        System.out.println(userDao.getUser(3L).toString());
        User user1 = userDao.getUser(3L);
        userDao.deleteUser(user1);
        return "account";
    }
}
