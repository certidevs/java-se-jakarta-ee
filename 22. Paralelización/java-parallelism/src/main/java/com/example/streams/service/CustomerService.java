package com.example.streams.service;


import com.example.streams.model.Customer;

import java.util.Set;

public interface CustomerService {

    Customer save(Long id, String name);

    Customer findById(Long id);

    Set<Customer> findAll();
}
