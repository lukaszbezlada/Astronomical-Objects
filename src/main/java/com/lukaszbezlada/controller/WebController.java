package com.lukaszbezlada.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    @RequestMapping("/account")
    public String account() {
        return "account.html";
    }

    @RequestMapping("/messierdirectory")
    public String messier() {
        return "messierdirectory.html";
    }

    @RequestMapping("/registration")
    public String registration() {
        return "registration.html";
    }

}
