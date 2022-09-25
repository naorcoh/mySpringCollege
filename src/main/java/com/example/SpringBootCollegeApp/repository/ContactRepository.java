package com.example.SpringBootCollegeApp.repository;

import com.example.SpringBootCollegeApp.model.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
@Slf4j
public class ContactRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int saveInquiry(Contact contact) {
        log.info(contact.toString() + " repository");

        String sqlQuery ="INSERT INTO inquiry (name, mobile_num, email, subject, message, status, created_at, created_by) values(?, ?, ?, ?, ?, ?, ?, ?)";
       return jdbcTemplate.update(
                sqlQuery,
                contact.getName(),
                contact.getMobileNum(),
                contact.getEmail(),
                contact.getSubject(),
                contact.getMessage(),
                contact.getStatus(),
                contact.getCreatedAt(),
                contact.getCreatedBy()
        );
    }
}
