package com.example.SpringBootCollegeApp.repository;

import com.example.SpringBootCollegeApp.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
