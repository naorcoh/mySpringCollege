package com.example.SpringBootCollegeApp.repository;

import com.example.SpringBootCollegeApp.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {
    Roles getByRoleName(String roleName);
}
