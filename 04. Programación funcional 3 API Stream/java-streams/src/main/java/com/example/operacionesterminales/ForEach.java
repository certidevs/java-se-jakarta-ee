package com.example.operacionesterminales;

import com.example.operacionesintermedias.Product;

import java.util.ArrayList;
import java.util.List;

public class ForEach {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("product1", 9.99));
        products.add(new Product("product2", 19.99));
        products.add(new Product("product3", 29.99));
        products.add(new Product("product4", 39.99));
        products.add(new Product("product5", 49.99));

        products.stream()
                .filter(product -> product.getPrice() > 10.0)
                .forEach(product -> product.setPrice(product.getPrice() + product.getPrice() * 0.21));
        System.out.println(products);
    }
}
