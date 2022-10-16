package com.example.SpringBootCollegeApp.rest;

import com.example.SpringBootCollegeApp.model.CustomHttpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(annotations = RestController.class)
@Order(1)
public class ExceptionRestController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomHttpResponse> exceptionHandler(Exception e) {

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new CustomHttpResponse(500, e.getMessage()));
    }


}
