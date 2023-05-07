package com.example.collect;

import com.example.Developer;
import com.example.Product;
import com.example.Task;

import java.util.*;
import java.util.stream.Collectors;

public class CollectMain {

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(List.of(
                new Product("1", "product1", 9.99, false),
                new Product("2", "product2", 5.99, false),
                new Product("3", "product3", 39.99, false),
                new Product("4", "product4", 19.99, false)
        ));
        Set<Product> productSet = products.stream()
                .filter(product -> product.getPrice() > 10)
                .collect(Collectors.toSet());

        String names = products.stream()
                .filter(product -> product.getPrice() > 5)
                .map(Product::getName)
                .collect(Collectors.joining(", "));
        System.out.println(names);

        DoubleSummaryStatistics stats = products.stream()
                .collect(Collectors.summarizingDouble(Product::getPrice));

        System.out.println(stats.getCount());
        System.out.println(stats.getMin());
        System.out.println(stats.getMax());
        System.out.println(stats.getAverage());
        System.out.println(stats.getSum());

        List<Developer> devs = getDevelopers();
        Map<Integer, List<Developer>> devGroups = devs.stream()
                .collect(Collectors.groupingBy(Developer::getAge));

        System.out.println(devGroups);

        products.stream().mapToDouble(Product::getPrice).average().ifPresent(System.out::println);
    }

    private static List<Developer> getDevelopers() {
        Task task1 = new Task(1L, "task1", 5);
        Task task2 = new Task(2L, "task2", 4);
        Task task3 = new Task(3L, "task3", 6);
        Developer dev1 = new Developer("dev1", 20, List.of(task1, task2, task3));

        Task task4 = new Task(4L, "task4", 2);
        Task task5 = new Task(5L, "task5", 10);
        Task task6 = new Task(6L, "task6", 7);
        Developer dev2 = new Developer("dev2", 30, List.of(task4, task5, task6));

        Developer dev3 = new Developer("dev2", 30, List.of());

        return List.of(dev1, dev2, dev3);
    }
}
