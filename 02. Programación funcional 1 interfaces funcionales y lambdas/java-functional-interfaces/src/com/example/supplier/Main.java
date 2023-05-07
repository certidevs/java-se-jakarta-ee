package com.example.supplier;

import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {

        Supplier<Double> generator = () -> Math.random();
        System.out.println(generator.get());
        System.out.println(generator.get());
        System.out.println(generator.get());


        Supplier<Integer> generator2 = () -> new Random().nextInt(500 + 1);
        System.out.println(generator2.get());
        System.out.println(generator2.get());
        System.out.println(generator2.get());

        Supplier<String> uuidGenerator = () -> UUID.randomUUID().toString();
        System.out.println(uuidGenerator.get());
        System.out.println(uuidGenerator.get());
        System.out.println(uuidGenerator.get());

        Supplier<Person> personGenerator = () -> new Person();
    }
}
