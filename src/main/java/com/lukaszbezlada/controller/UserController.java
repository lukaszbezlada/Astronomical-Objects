package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {


    private UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @PostMapping("/addUser")
    public String addArticle(@ModelAttribute User formRegistration, Model model) {
        if (checkNotEmpty(formRegistration)) {
            model.addAttribute("formRegistration", formRegistration);
            userDao.addUser(formRegistration);
            return "success";
        } else
            return "redirect:sorry";
    }

    @GetMapping("/sorry")
    public String error() {
        return "errorMessage";
    }

    private boolean checkNotEmpty(User user) {
        return (user.getFirstName() != null && user.getFirstName().length() > 0)
                && (user.getLastName() != null && user.getLastName().length() > 0)
                && (user.getLogin() != null && user.getLogin().length() > 0)
                && (user.getEmail() != null && user.getEmail().length() > 0)
                && (user.getPassword() != null && user.getPassword().length() > 0);
    }
}
