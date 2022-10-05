package com.example.SpringBootCollegeApp.controller;

import com.example.SpringBootCollegeApp.model.Contact;
import com.example.SpringBootCollegeApp.service.ContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

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


        contactService.saveMessageDetails(contact);
        return "redirect:/contact";
    }

    @GetMapping("/displayInquiries")
    public ModelAndView displayInquiries(Model model) {

        ModelAndView modelAndView = new ModelAndView();
        List<Contact> inquiriesList = contactService.findInquiresByStatus();
        modelAndView.setViewName("inquiries");
        modelAndView.addObject("inquiriesList", inquiriesList);


        return modelAndView;
    }

    @GetMapping("/closeInquiry")
    public String closeInquiry(@RequestParam int id) {

        contactService.updateInquiryStatus(id);

        return "redirect:/displayInquiries";
    }



}
