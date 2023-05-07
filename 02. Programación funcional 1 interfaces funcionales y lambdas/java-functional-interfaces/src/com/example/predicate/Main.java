package com.example.predicate;

import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Predicate<String> validateName = name -> name.length() > 5 && name.length() < 15;

        System.out.println(validateName.test("alan")); // false
        System.out.println(validateName.test("openwebinars")); // true
        System.out.println(validateName.test("openwebinarsholaquetal")); // false

        List<String> names = List.of("alan", "patricia", "eva");
        for (String name : names) {
            if(validateName.test(name))
                System.out.println(name);
        }

        // equivalente al anterior pero en versión funcional
        names.stream()
                .filter(name -> name.length() > 5)
                .forEach(name -> System.out.println(name));


    }
}
