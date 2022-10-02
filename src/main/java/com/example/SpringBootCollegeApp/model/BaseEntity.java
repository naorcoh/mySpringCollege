package com.example.SpringBootCollegeApp.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class BaseEntity {

    private String updateBy;
    private String createdBy;
    private LocalDateTime updateAt;
    private LocalDateTime createdAt;

}
