package com.MyCrudApp.app.controllers;

import com.MyCrudApp.app.models.User;
import com.MyCrudApp.app.service.RoleService;
import com.MyCrudApp.app.service.RoleServiceImpl;
import com.MyCrudApp.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService us;

    private final RoleServiceImpl rs;
    @Autowired
    public AdminController(UserService us, RoleServiceImpl rs) {
        this.us = us;
        this.rs = rs;
    }

    @GetMapping()
    public String printWelcome(ModelMap model) {
        model.addAttribute("user", us.getAllUsers());
        return "admin";
    }

    @GetMapping("/new")
    public String newCustomerForm(ModelMap model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping
    public String saveUser(@ModelAttribute("User") User user) {
        us.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/editUser")
    public String edit (ModelMap model, @PathVariable("id") long id) {
        model.addAttribute("allRoles", rs.getAllRole());
        model.addAttribute("user",us.findById(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("User") User user, @PathVariable("id")  long id){
        us.update(id,user);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/deleter")
    public String delete(@PathVariable("id") long id){
        us.delete(id);
        return "redirect:/admin";
    }
}
