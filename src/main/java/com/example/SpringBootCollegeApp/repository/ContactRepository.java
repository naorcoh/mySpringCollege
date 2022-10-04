package com.example.SpringBootCollegeApp.repository;

import com.example.SpringBootCollegeApp.mappers.ContactMapper;
import com.example.SpringBootCollegeApp.model.Contact;
import com.example.SpringBootCollegeApp.model.enums.EInquiryStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


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

    public List<Contact> findByStatus(EInquiryStatus status) {

        String sqlQuery = "SELECT * FROM Inquiry WHERE status = ?";

        return jdbcTemplate.query(sqlQuery, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status.toString());
            }
        }, new ContactMapper());

    }

    public int updateInquiryStatus(int inquiryId, EInquiryStatus status, String updatedBy) {

        String sqlQuery = "UPDATE inquiry SET status = ?, updated_by = ?, updated_at = ? WHERE inquiry_id = ?";

        PreparedStatementSetter pss = new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, status.toString());
                ps.setString(2, updatedBy);
                ps.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                ps.setInt(4, inquiryId);

            }
        };

        return jdbcTemplate.update(sqlQuery,pss);
    }
}
