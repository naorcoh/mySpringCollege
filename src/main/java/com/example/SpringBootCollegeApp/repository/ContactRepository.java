package com.example.SpringBootCollegeApp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ContactRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;
}
