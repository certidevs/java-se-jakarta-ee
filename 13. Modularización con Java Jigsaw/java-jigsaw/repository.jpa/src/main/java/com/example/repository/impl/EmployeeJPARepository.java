package com.example.repository.impl;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeJPARepository implements EmployeeRepository {
    @Override
    public List<Employee> findAll() {
        return new ArrayList<>();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.empty();
    }
}
