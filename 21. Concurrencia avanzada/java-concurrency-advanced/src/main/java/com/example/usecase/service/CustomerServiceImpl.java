package com.example.usecase.service;

import com.example.usecase.model.Customer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CustomerServiceImpl implements CustomerService{

    Set<Customer> customers = new HashSet<>();

    @Override
    public Customer save(Long id, String name) {
        var customer = new Customer(id, name);
        customers.add(customer);
        return customer;
    }

    @Override
    public Customer findById(Long id) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return customers.stream()
                .filter(customer -> Objects.equals(id, customer.id()))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Set<Customer> findAll() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!this.customers.isEmpty()) {
            return this.customers;
        }
        throw new RuntimeException("No customer found");
    }
}
