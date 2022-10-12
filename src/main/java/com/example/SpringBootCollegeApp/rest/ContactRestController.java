package com.example.SpringBootCollegeApp.rest;

import com.example.SpringBootCollegeApp.model.Contact;
import com.example.SpringBootCollegeApp.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(path = "/api/inquiries")
public class ContactRestController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping("/getInquiriesByStatus")
    public List<Contact> getInquiriesByStatus(@RequestParam String status) {
        return contactRepository.findByStatus(status);
    }

    @GetMapping("/getInquiriesBySubject")
    public List<Contact> getInquiriesBySubject(@RequestBody Contact contact) {
        if (contact != null && contact.getSubject() != null)
            return contactRepository.findBySubjectContaining(contact.getSubject());
        else
            return Collections.emptyList();
    }

    @PostMapping("/saveInquiry")
    public ResponseEntity<Contact> saveInquiry(@Valid @RequestBody Contact contact) {

        Contact queryResponse = contactRepository.save(contact);

        return ResponseEntity.status(HttpStatus.CREATED)
                .header("isInquirySaved", "true")
                .body(queryResponse);
    }
}
