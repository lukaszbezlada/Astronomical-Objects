package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.entity.UserStatus;
import com.lukaszbezlada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User formRegistration, Model model) {
        if (checkNotEmpty(formRegistration)) {
            formRegistration.setStatus(UserStatus.Aktywny);
            userRepository.save(formRegistration);
            String registrationSuccess = "Utworzono poprawnie konto";
            model.addAttribute("registrationSuccess", registrationSuccess);
            return "account";
        } else {
            String registrationError = "Uzupełnij wszystkie pola!";
            model.addAttribute("registrationError", registrationError);
            return "redirect:/registration";
        }
    }

    private boolean checkNotEmpty(User user) {
        return (user.getFirstName() != null && user.getFirstName().length() > 0)
                && (user.getLastName() != null && user.getLastName().length() > 0)
                && (user.getLogin() != null && user.getLogin().length() > 0)
                && (user.getEmail() != null && user.getEmail().length() > 0)
                && (user.getPassword() != null && user.getPassword().length() > 0);
    }
}
