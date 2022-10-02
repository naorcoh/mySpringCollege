package com.example.SpringBootCollegeApp.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@Table(name = "inquiry")
public class Contact extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int inquiryId;
    private String status;

    @NotBlank(message = "Name must not be blank!")
    @Size(min = 3, message = "Name must be at least 3 characters long!")
    private String name;

    @NotBlank(message = "Mobile phone must not be blank!")
    @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNum;

    @NotBlank(message = "Email must not be blank!")
    @Email(message = "Please provide a valid email address!")
    private String email;

    @NotBlank(message = "subject must not be blank!")
    @Size(min = 5, message = "subject must be at least 5 characters long!")
    private String subject;

    @NotBlank(message = "message must not be blank!")
    @Size(min = 10, message = "message must be at least 10 characters long!")
    private String message;


}
