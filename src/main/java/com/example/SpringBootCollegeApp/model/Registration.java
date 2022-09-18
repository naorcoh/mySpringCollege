package com.example.SpringBootCollegeApp.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class Registration {
    @NotBlank(message = "Name must not be blank!")
    @Size(min = 3, message = "Name must be at least 3 characters long!")
    private String name;

    @NotBlank(message = "Email must not be blank!")
    @Email(message = "Please provide a valid email address!")
    private String email;

    @NotBlank(message = "subject must not be blank!")
    @Size(min = 5, message = "subject must be at least 5 characters long!")
    private String phone;

    @NotBlank(message = "message must not be blank!")
    @Size(min = 10, message = "message must be at least 10 characters long!")
    private String password;

}
