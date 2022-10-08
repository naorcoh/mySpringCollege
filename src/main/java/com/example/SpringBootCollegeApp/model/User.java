package com.example.SpringBootCollegeApp.model;

import com.example.SpringBootCollegeApp.annotation.FieldsMatch;
import com.example.SpringBootCollegeApp.annotation.SecuredPassword;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@Entity
@FieldsMatch.List({

        @FieldsMatch(filedOne = "pwd", filedTwo = "confirmPwd", message = "Passwords do not match!"),
        @FieldsMatch(filedOne = "email", filedTwo = "confirmEmail", message = "Emails do not match!")
})
public class User extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int userId;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, message = "Name must be at least 3 characters long!")
    private String name;

    @NotBlank(message = "Mobile number cannot be blank!")
    @Pattern(regexp = "[0-9]{10}", message = "Please enter 10 digits!")
    private String mobileNumber;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Email address is not valid!")
    private String email;

    @NotBlank(message = "Confirm email cannot be blank")
    @Transient
    private String confirmEmail;

    @NotBlank(message = "Password filed cannot be blank")
    @SecuredPassword
    private String pwd;

    @NotBlank(message = "Confirm password cannot be blank")
    @Transient
    private String confirmPwd;

}
