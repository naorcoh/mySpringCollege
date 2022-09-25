package com.example.SpringBootCollegeApp.sevice;

import com.example.SpringBootCollegeApp.model.Contact;
import com.example.SpringBootCollegeApp.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return true;

        //TODO insert data into database table
    }
}
