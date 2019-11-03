package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.utils.MessierObject;
import com.lukaszbezlada.utils.MessierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {


    private MessierService messierService;

    @Autowired
    public WebController(MessierService messierService) {
        this.messierService = messierService;
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/account")
    public String account() {
        return "account";
    }

    @GetMapping("/messierdirectory")
    public String messier(Model model) {
        model.addAttribute("messierObjectAttribute", new MessierObject());
        model.addAttribute("messierListAttribute", messierService.readFile());
        return "messierdirectory";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("formRegistration", new User());
        return "registration";
    }

}
