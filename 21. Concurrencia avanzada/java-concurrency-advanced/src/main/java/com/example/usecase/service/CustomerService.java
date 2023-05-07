package com.example.usecase.service;

import com.example.usecase.model.Customer;

import java.util.Set;

public interface CustomerService {

    Customer save(Long id, String name);

    Customer findById(Long id);

    Set<Customer> findAll();
}
