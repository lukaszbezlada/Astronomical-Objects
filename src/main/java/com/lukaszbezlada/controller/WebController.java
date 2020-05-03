package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.SkyObject;
import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.entity.MessierObject;
import com.lukaszbezlada.repository.MessierRepository;
import com.lukaszbezlada.service.SkyObjectService;
import com.lukaszbezlada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {


    private MessierRepository messierRepository;
    private SkyObjectService skyObjectService;
    private UserService userService;

    @Autowired
    public WebController(MessierRepository messierRepository, SkyObjectService skyObjectService, UserService userService) {
        this.messierRepository = messierRepository;
        this.skyObjectService = skyObjectService;
        this.userService = userService;
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
        model.addAttribute("messierListAttribute", messierRepository.readFile());
        return "messierdirectory";
    }

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String registrationWithEmail(@RequestParam(name = "e_mail", required = false) String e_mail, Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("e_mail", e_mail);
        return "registration";
    }

    @RequestMapping("/account")
    public String account(Model model) {
        model.addAttribute("skyObject", new SkyObject());
        return "account";
    }

    @GetMapping("/skyobjects")
    public String skyobjects(Model model) {
        model.addAttribute("skyObjectUserList", skyObjectService.findUserSkyObjects());
        return "skyobjects";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("userList", userService.findAllUsers());
        return "admin";
    }


    @RequestMapping("/failure")
    public String failure(Model model) {
        model.addAttribute("failure", "Wprowadzono niepoprawne dane użytkownika");
        return "login";
    }

}
