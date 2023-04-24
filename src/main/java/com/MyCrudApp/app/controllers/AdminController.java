package com.MyCrudApp.app.controllers;

import com.MyCrudApp.app.models.User;
import com.MyCrudApp.app.service.RoleService;
import com.MyCrudApp.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.Principal;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String getAllUsers(@ModelAttribute("user") User user,
                              Principal principal, Model model) {
        Long id = userService.findByUsername(principal.getName()).getId();
        model.addAttribute("admin", userService.findById(id));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", roleService.getAllRole());
        return "admin";
    }
    @PostMapping("/new")
    public String saveUser(@ModelAttribute("user") User user){
        userService.save(user);
        return "redirect:/admin";
    }
    @GetMapping("/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleService.getAllRole());
        return "redirect:/admin";
    }
    @PatchMapping("/{id}")
    public String editUser(@PathVariable("id") long id,
                           @ModelAttribute("user") User user){
        userService.update(id, user);
        return "redirect:/admin";
    }
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.delete(id);
        return "redirect:/admin";
    }
}