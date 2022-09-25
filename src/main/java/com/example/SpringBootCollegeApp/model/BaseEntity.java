package com.example.SpringBootCollegeApp.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseEntity {

    private String updateBy;
    private String createdBy;
    private LocalDateTime updateAt;
    private LocalDateTime createdAt;

}
