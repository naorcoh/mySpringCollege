package com.example.SpringBootCollegeApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomHttpRequest {

    private int statusCode;
    private String message;


}
