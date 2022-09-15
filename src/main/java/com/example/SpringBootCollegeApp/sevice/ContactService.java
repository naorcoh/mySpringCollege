package com.example.SpringBootCollegeApp.sevice;

import com.example.SpringBootCollegeApp.model.Contact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private Logger logger = LoggerFactory.getLogger(ContactService.class);
    /**
     *
     * @param contact
     * @return
     */

    public boolean saveMessageDetails(Contact contact) {
        logger.info(contact.toString());
        return true;

        //TODO insert data into database table
    }
}
