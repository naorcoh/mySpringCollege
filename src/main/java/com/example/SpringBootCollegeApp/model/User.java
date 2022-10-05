package com.example.SpringBootCollegeApp.model;

import lombok.Data;

import javax.persistence.Entity;

@Data

public class User extends BaseEntity{
    private String name;
    private String mobileNumber;
    private String email;
    private String confirmEmail;
    private String pwd;
    private String confirmPwd;

}
