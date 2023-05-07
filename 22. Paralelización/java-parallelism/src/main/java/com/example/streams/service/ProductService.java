package com.example.streams.service;


import com.example.streams.model.Product;

import java.util.Set;

public interface ProductService {

    Product findById(Long id);

    Product save(Long id, String name, Double price);

    Set<Product> findAll();

}
