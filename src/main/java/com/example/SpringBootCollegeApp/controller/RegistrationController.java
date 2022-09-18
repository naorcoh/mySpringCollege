package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.Registration;
import com.example.SpringBootCollegeApp.sevice.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@Slf4j
public class RegistrationController {
    private final ContactService contactService;

    @Autowired
    public RegistrationController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/registration")
    public String displayRegistration(Model model) {

        model.addAttribute("registration", new Registration());
        return "registration.html";
    }

    @PostMapping("saveUser")
    public String saveUser(@Valid @ModelAttribute("registration") Registration registration,
                           Errors errors,
                           Model model
) {
        if (errors.hasErrors()) {
            log.info("registration form validation failed : " + errors);
            return "registration";
        }
        model.addAttribute("success", true);
        model.addAttribute("email", registration.getEmail());


       contactService.saveUserDetails(registration);

        return "registration.html";
    }
}
