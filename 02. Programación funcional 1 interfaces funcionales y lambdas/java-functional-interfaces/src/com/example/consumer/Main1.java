package com.example.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Main1 {

    public static void main(String[] args) {

        // Clases anónimas
        Consumer<String> printer = new Consumer<String>() {
            @Override
            public void accept(String message) {
                System.out.println(message);
            }
        };

        printer.accept("Hola mundo");

        // Lambdas
        Consumer<String> printer1 = message -> System.out.println(message);
        Consumer<String> printer2 = message -> System.out.println(message);
        printer1.accept("Hola mundo desde lambda");

        Consumer<String> printer12 = printer1.andThen(printer2);
        printer12.accept("Adios");

        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");

        names.forEach(name -> System.out.println(name));

    }
}
