package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.Contact;
import com.example.SpringBootCollegeApp.sevice.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
@Slf4j
@Controller
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage(Model model) {
        model.addAttribute("contact", new Contact());

        return "contact.html";
    }

    @PostMapping("saveMsg")
    public String saveMessage(@Valid @ModelAttribute("contact") Contact contact, Errors errors) {

        if (errors.hasErrors()) {
            log.info("Contact form validation failed : " + errors);
            return "contact.html";
        }
        contactService.setCounter(contactService.getCounter() + 1);
        log.info("Number of time contact form was submitted : " + contactService.getCounter());


        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

}
