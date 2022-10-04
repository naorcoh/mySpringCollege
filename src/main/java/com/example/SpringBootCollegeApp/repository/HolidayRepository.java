package com.example.SpringBootCollegeApp.repository;
import com.example.SpringBootCollegeApp.model.Holiday;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HolidayRepository extends CrudRepository<Holiday, String> {

}
