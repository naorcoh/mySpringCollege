package com.example.SpringBootCollegeApp.repository;

import com.example.SpringBootCollegeApp.model.Contact;
import com.example.SpringBootCollegeApp.model.enums.EInquiryStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
    List<Contact> findByStatus(String status);

}
