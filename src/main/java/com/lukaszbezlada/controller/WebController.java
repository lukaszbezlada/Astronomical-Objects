package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.utils.MessierObject;
import com.lukaszbezlada.utils.MessierService;
import com.lukaszbezlada.utils.SkyObjectService;
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
    private SkyObjectService skyObjectService;

    @Autowired
    public WebController(MessierService messierService, SkyObjectService skyObjectService) {
        this.messierService = messierService;
        this.skyObjectService = skyObjectService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
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
    public String registrationWithEmail(@RequestParam(name = "e_mail") String e_mail, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("e_mail", e_mail);
        return "registration";
    }

    @RequestMapping("/account")
    public String account(Model model) {
        model.addAttribute("skyObject", new SkyObject());
        model.addAttribute("skyObjectUserList", skyObjectService.findUserSkyObjects());
        return "account";
    }

    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }


    @RequestMapping("/failure")
    public String failure(Model model) {
        model.addAttribute("failure", "Wprowadzono niepoprawne dane użytkownika");
        return "login";
    }

}
