package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.utils.MessierObject;
import com.lukaszbezlada.utils.MessierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {


    private MessierService messierService;

    @Autowired
    public WebController(MessierService messierService) {
        this.messierService = messierService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
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
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationWithEmail(@RequestParam(name="e_mail") String e_mail, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("e_mail", e_mail);
        return "registration";
    }

    @RequestMapping("/secret")
    public String secret() {
        return "secret";
    }

    @RequestMapping("/failure")
    public String failure(Model model) {
        model.addAttribute("failure", "Wprowadzono niepoprawne dane użytkownika");
        return "account";
    }

    @PostMapping("/account")
    public String account(Model model) {
        model.addAttribute("login", "Zalogowano użytkownika");
        return "secret";
    }

}
