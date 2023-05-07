package com.example.methodreference.constructormethods;

@FunctionalInterface
public interface EmployeeWithName {
    Employee create(String name);
}
