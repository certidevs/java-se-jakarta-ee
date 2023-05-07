package com.example.usecase.service;

import com.example.usecase.model.Product;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class ProductServiceImpl implements ProductService{

    Set<Product> products = new HashSet<>();

    @Override
    public Product findById(Long id) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return products.stream()
                .filter(product -> Objects.equals(id, product.id()))
                .findFirst()
                .orElseThrow();
    }

    @Override
    public Product save(Long id, String name, Double price) {
        var product = new Product(id, name, price);
        products.add(product);
        return product;
    }

    @Override
    public Set<Product> findAll() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!this.products.isEmpty()) {
            return this.products;
        }
        throw new RuntimeException("No product found");
    }
}
