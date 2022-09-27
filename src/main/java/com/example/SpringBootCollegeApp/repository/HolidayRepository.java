package com.example.SpringBootCollegeApp.repository;

import com.example.SpringBootCollegeApp.mappers.HolidayMapper;
import com.example.SpringBootCollegeApp.model.Holiday;
import com.example.SpringBootCollegeApp.model.enums.EUserRoles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@Slf4j
public class HolidayRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public HolidayRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public List<Holiday> selectAllHoliday() {

        String sqlQuery = "SELECT * FROM holidays";

        return jdbcTemplate.query(sqlQuery, new HolidayMapper());
    }
}
