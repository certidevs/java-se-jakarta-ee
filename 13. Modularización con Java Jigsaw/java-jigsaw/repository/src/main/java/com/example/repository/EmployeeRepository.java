package com.example.repository;

import com.example.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    List<Employee> findAll();
    Optional<Employee> findById(Long id);
}
