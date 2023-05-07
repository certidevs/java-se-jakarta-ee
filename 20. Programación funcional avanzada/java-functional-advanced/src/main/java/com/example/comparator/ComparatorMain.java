package com.example.comparator;

import com.example.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorMain {

    public static void main(String[] args) {

        Comparator<Double> comparator1 = (n1, n2) -> n1.compareTo(n2);
        Comparator<Double> comparator2 = Double::compareTo;
        System.out.println(comparator1.compare(50.0, 100.0));
        System.out.println(comparator1.compare(50.0, 50.0));
        System.out.println(comparator1.compare(100.0, 50.0));

        Product product1 = new Product("1", "product1", 49.99, false);
        Product product2 = new Product("2", "product2", 19.99, false);

//        Comparator<Product> productComparator = (p1, p2) -> p1.getPrice().compareTo(p2.getPrice());
        Comparator<Product> productComparator = Comparator.comparing(Product::getPrice);
        System.out.println(productComparator.compare(product1, product2));

        List<Product> products = new ArrayList<>(List.of(
                new Product("1", "product1", 9.99, false),
                new Product("2", "product2", 5.99, false),
                new Product("3", "product3", 39.99, false),
                new Product("3", "product3", 19.99, false)
        ));
        System.out.println(products);
//        products.sort(productComparator);
//        products.sort(productComparator.reversed());
        Collections.sort(products, productComparator);
        System.out.println(products);


    }
}
