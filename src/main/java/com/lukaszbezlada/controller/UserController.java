package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {

        if (!checkPassword(user))
            model.addAttribute("invalidPasswords", "Podane hasła są różne");

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
        }

        if (!result.hasErrors() && checkPassword(user)) {
            userService.addUserWithDefaultRole(user);
            String registrationSuccess = "Utworzono poprawnie konto";
            model.addAttribute("registrationSuccess", registrationSuccess);
            return "login";
        }
        return "registration";
    }

    private boolean checkPassword(User user) {
        return user.getPassword2().equals(user.getPassword());
    }

    @GetMapping("/editUser?user={userId}")
    public String editUser(@PathVariable(name="userId") Long userId, Model model) {
        Optional<User> user = userService.findUserById(userId);
        model.addAttribute("userClicked", user);
        return "editUser";
    }
}