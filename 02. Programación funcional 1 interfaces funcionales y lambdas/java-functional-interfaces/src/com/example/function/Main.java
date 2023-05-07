package com.example.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {

        Function<String, Integer> extractLength = title -> title.length();

        Integer titleLength = extractLength.apply("Hola mundo");
        System.out.println(titleLength);

        BiFunction<Integer, Integer, Integer> divider = (num1, num2) -> num1 / num2;
        System.out.println(divider.apply(10, 10));


    }
}
