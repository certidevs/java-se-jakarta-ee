package com.example.collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {

    public static void main(String[] args) {


        Set<Integer> numbers = new HashSet<>();
        numbers.add(100); // true
        numbers.add(50); // true
        numbers.add(20); // true
        numbers.add(100); // false
        numbers.forEach(System.out::println);

        Set<Integer> numbers2 = new TreeSet<>();
        numbers2.add(100); // true
        numbers2.add(50); // true
        numbers2.add(20); // true
        numbers2.add(100); // false
        numbers2.forEach(System.out::println);

        Set<String> dnis = Set.of("77766655E", "77766655R");
        System.out.println(dnis);


    }
}
