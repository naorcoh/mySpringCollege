package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.Contact;
import com.example.SpringBootCollegeApp.sevice.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String displayContactPage() {

        return "contact.html";
    }

    @PostMapping("saveMsg")
    public ModelAndView saveMessage(Contact contact) {

        contactService.saveMessageDetails(contact);
        return new ModelAndView("redirect:/contact");
    }

}
