package com.example.SpringBootCollegeApp.mappers;

import com.example.SpringBootCollegeApp.model.Holiday;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HolidayMapper implements RowMapper<Holiday> {
    @Override
    public Holiday mapRow(ResultSet rs, int rowNum) throws SQLException {
        Holiday holiday = new Holiday();
        holiday.setDay(rs.getString("day"));
        holiday.setReason(rs.getString("reason"));
        holiday.setType(Holiday.Type.valueOf(rs.getString("type").toString()));
        holiday.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
        holiday.setCreatedBy(rs.getString("created_by"));

        if (rs.getTimestamp("updated_at") != null)
            holiday.setUpdateAt(rs.getTimestamp("updated_at").toLocalDateTime());

        if (rs.getString("updated_by") != null)
            holiday.setUpdateBy(rs.getString("updated_by"));
        return holiday;
    }
}
