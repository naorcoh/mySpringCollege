package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.User;
import com.example.SpringBootCollegeApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String displayRegistrationPage(Model model) {

        model.addAttribute("user", new User());
        return "registration.html";
    }


    @PostMapping("/createUser")
    public String createUser(@Valid @ModelAttribute("user") User user, Errors errors) {

        if (errors.hasErrors())
            return "registration.html";

        return "redirect:/login?register=true";
    }


}
