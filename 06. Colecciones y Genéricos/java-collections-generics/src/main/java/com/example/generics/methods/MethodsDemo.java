package com.example.generics.methods;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class MethodsDemo {

    public static void main(String[] args) {

        List<Customer> customers = List.of(
                new Customer(1L, "juan"),
                new Customer(2L, "bob"),
                new Customer(3L, "mike"),
                new Customer(4L, "john")
        );

        List<Long> ids = MethodsDemo.filterAndExtract(
                customers,
                customer -> customer.name.startsWith("j"),
                customer -> customer.id
        );

        System.out.println(ids);

    }

    private static <T, R> List<R> filterAndExtract(List<T> items,
                                                   Predicate<T> filter,
                                                   Function<T, R> extractor){

        List<R> results = new ArrayList<>();
        for (T item: items){
            if (filter.test(item)){
                R result = extractor.apply(item);
                results.add(result);
            }
        }
        return results;
    }

}


