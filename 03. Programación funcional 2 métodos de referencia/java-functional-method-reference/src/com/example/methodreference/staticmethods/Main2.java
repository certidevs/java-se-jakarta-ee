package com.example.methodreference.staticmethods;

import java.util.List;
import java.util.function.Predicate;

public class Main2 {

    public static void main(String[] args) {

//        Predicate<Integer> esPar = num -> Operations.esPar(num);
        Predicate<Integer> esPar = Operations::esPar;
        System.out.println(esPar.test(4));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        numbers.stream()
                .filter(Operations::esPar)
                .filter(Operations::esPositivo)
                .forEach(System.out::println);
    }
}

class Operations{

    static boolean esPar(int num){
        return num % 2 == 0;
    }

    static boolean esNegativo(int num){
        return num < 0;
    }
    static boolean esPositivo(int num){
        return num >= 0;
    }
}