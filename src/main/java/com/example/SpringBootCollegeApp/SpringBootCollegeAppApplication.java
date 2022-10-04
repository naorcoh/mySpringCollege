package com.example.SpringBootCollegeApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.example.SpringBootCollegeApp.repository")
@EntityScan("com.example.SpringBootCollegeApp.model")
public class SpringBootCollegeAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCollegeAppApplication.class, args);
	}

}
