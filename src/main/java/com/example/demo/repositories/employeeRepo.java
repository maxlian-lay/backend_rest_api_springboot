package com.example.demo.repositories;

import java.util.List;

import com.example.demo.dto.employeeDto;
import com.example.demo.models.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepo extends JpaRepository<employee,Long>{
  @Query("SELECT new com.example.demo.dto.employeeDto(e.id,e.employee_name,e.employee_sallary,e.grade_id,g.grade_name,g.grade_bonus) FROM employee e JOIN grade g on e.grade_id = g.id")
    public List<employeeDto> getEmployeeInfo();
}