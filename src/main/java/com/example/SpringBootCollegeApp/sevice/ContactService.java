package com.example.SpringBootCollegeApp.sevice;

import com.example.SpringBootCollegeApp.model.Contact;
import com.example.SpringBootCollegeApp.model.enums.EInquiryStatus;
import com.example.SpringBootCollegeApp.model.enums.EUserRoles;
import com.example.SpringBootCollegeApp.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class ContactService {
    @Autowired
    ContactRepository contactRepository;

    /**
     *
     * @param contact
     * @return
     */

    public boolean saveMessageDetails(Contact contact) {

        log.info(contact.toString());

        contact.setCreatedAt(LocalDateTime.now());
        contact.setCreatedBy(EUserRoles.ANONYMOUS.toString());
        contact.setStatus(EInquiryStatus.OPEN.toString());

        int queryResults = contactRepository.saveInquiry(contact);
        return (queryResults > 0);


    }
}
