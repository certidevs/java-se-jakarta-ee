package com.example.methodreference.constructormethods;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        // 0 argumentos
//        Supplier<Employee> generator = () -> new Employee();
        Supplier<Employee> generator = Employee::new;




        // 1 argumento
        // Supplier no permitiría pasar un argumento
        Supplier<Employee> generator2 = () -> new Employee("name");
//        EmployeeWithName generator3 = name -> new Employee(name);
        EmployeeWithName generator3 = Employee::new;
        generator3.create("Employee 1");

        // 2 argumentos
//        BiFunction<String, Integer, Employee> generator4 = (name, age) -> new Employee(name, age);
        BiFunction<String, Integer, Employee> generator4 = Employee::new;
        Employee employee2 = generator4.apply("Employee 2", 30);


    }
}

