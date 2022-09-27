package com.example.SpringBootCollegeApp.repository;

import com.example.SpringBootCollegeApp.model.Holiday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HolidayRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Holiday>  findAllHoliday() {

        String sqlQuery = "SELECT * FROM holidays";

        return jdbcTemplate.query(sqlQuery, BeanPropertyRowMapper.newInstance(Holiday.class));
    }
}
