package com.MyCrudApp.app.controllers;

import com.MyCrudApp.app.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;



@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String showUser (Model model, Principal principal) {
        model.addAttribute("admin", userService.findByUsername(principal.getName()));
        return "user";
    }
}
