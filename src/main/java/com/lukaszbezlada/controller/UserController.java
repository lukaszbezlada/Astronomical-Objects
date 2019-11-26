package com.lukaszbezlada.controller;

import com.lukaszbezlada.entity.User;
import com.lukaszbezlada.entity.UserStatus;
import com.lukaszbezlada.repository.UserRepository;
import com.lukaszbezlada.security.PasswordHashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private UserRepository userRepository;
    private final PasswordHashing passwordHashing;

    @Autowired
    public UserController(UserRepository userRepository, PasswordHashing passwordHashing) {
        this.userRepository = userRepository;
        this.passwordHashing = passwordHashing;
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
            user.setStatus(UserStatus.Aktywny);
            passwordHashing.passwordHashing(user);
            userRepository.save(user);
            String registrationSuccess = "Utworzono poprawnie konto";
            model.addAttribute("registrationSuccess", registrationSuccess);
            return "account";
        }
        return "registration";
    }

    private boolean checkPassword(User user) {
        return user.getPassword2().equals(user.getPassword());
    }
}