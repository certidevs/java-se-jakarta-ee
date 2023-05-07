package com.example.client;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;
import com.example.repository.impl.EmployeeJPARepository;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        EmployeeRepository repository = new EmployeeJPARepository();
        List<Employee> employees = repository.findAll();
    }
}
