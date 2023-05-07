package com.example.jakartajpa.repository;

import com.example.jakartajpa.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {

    List<Employee> findAll();
    Optional<Employee> findById(Long id);
    Employee save(Employee employee);
}
