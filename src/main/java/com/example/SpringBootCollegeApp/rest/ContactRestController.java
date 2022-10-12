package com.example.SpringBootCollegeApp.rest;

import com.example.SpringBootCollegeApp.model.Contact;
import com.example.SpringBootCollegeApp.model.enums.EInquiryStatus;
import com.example.SpringBootCollegeApp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(path = "/api/inquiries")
public class ContactRestController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/getInquiriesByStatus")
    @ResponseBody
    public List<Contact> getInquiriesByStatus(@RequestParam String status) {
        return contactRepository.findByStatus(status);
    }

    @GetMapping("/getInquiriesBySubject")
    @ResponseBody
    public List<Contact> getInquiriesBySubject(@RequestBody Contact contact) {
        if (contact != null && contact.getSubject() != null)
            return contactRepository.findBySubjectContaining(contact.getSubject());
        else
            return Collections.emptyList();
    }
}
