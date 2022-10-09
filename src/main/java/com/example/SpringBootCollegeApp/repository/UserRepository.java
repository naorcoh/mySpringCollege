package com.example.SpringBootCollegeApp.repository;

import com.example.SpringBootCollegeApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
