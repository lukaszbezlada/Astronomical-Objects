package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/account")
    public String account() {
        return "account";
    }

    @RequestMapping("/messierdirectory")
    public String messier() {
        return "messierdirectory";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("formRegistration", new User());
        return "registration";
    }

}
