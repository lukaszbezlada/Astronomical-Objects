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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/editUser")
    public String editUser(@RequestParam(name = "user") String userId, Model model) {
        Optional<User> userOptional = userService.findUserById(Long.parseLong(userId));
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("userClicked", user);
        }
        return "editUser";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam Long id, RedirectAttributes redirectAttr) {
        userService.deleteUserById(id);
        redirectAttr.addFlashAttribute("userDeleted", "Użytkownik został usunięty");
        return "redirect:users";
    }

    @PostMapping("/updateUser")
    public String updateUser(@Valid @ModelAttribute User userClicked, BindingResult result, RedirectAttributes redirectAttr, Model model) {
        model.addAttribute("userClicked", userClicked);

        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(err -> System.out.println(err.getDefaultMessage()));
        }
        if (result.getAllErrors().stream().allMatch(objectError -> objectError.getDefaultMessage().equals("Wpisz hasło"))) {
            Optional<User> userOptional = userService.findUserById(userClicked.getId());
            if (userOptional.isPresent()) {
                User userToUpdate = userOptional.get();
                userToUpdate.setEmail(userClicked.getEmail());
                userToUpdate.setLogin(userClicked.getLogin());
                userToUpdate.setFirstName(userClicked.getFirstName());
                userToUpdate.setLastName(userClicked.getLastName());
                userService.updateUser(userToUpdate);
                redirectAttr.addFlashAttribute("userUpdated", "Użytkownik został zaktualizowany");
                return "redirect:users";
            }
        }
        return "editUser";
    }
}