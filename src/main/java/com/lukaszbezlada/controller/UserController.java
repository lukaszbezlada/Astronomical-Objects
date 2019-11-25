package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.entity.UserStatus;
import com.lukaszbezlada.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/addUser")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            List<String> deafultsError = new ArrayList<>();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
        }

        if (!result.hasErrors()) {
            user.setStatus(UserStatus.Aktywny);
            userRepository.save(user);
            String registrationSuccess = "Utworzono poprawnie konto";
            model.addAttribute("registrationSuccess", registrationSuccess);
            return "account";
        }
        return "registration";
    }
//
//    private boolean checkNotEmpty(User user) {
//        return (user.getFirstName() != null && user.getFirstName().length() > 0)
//                && (user.getLastName() != null && user.getLastName().length() > 0)
//                && (user.getLogin() != null && user.getLogin().length() > 0)
//                && (user.getEmail() != null && user.getEmail().length() > 0)
//                && (user.getPassword() != null && user.getPassword().length() > 0);
//    }
}
