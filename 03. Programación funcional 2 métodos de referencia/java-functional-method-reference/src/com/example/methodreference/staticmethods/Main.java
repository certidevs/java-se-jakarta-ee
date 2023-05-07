package com.example.methodreference.staticmethods;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        // Incumple la condición al llamar a 2 métodos
        Predicate<Integer> checkPositive2 = num -> {
            System.out.println("Checking num: " + num);
            return PositiveNumber.isPositive(num);
        };
        System.out.println(checkPositive2.test(10));

        // lambda
        Predicate<Integer> checkPositive = num -> PositiveNumber.isPositive(num);
        System.out.println(checkPositive.test(10));

        // Method reference (equivalente al anterior)
        Predicate<Integer> checkPositive3 = PositiveNumber::isPositive;
        System.out.println(checkPositive3.test(10));

        Predicate<Integer> checkPositive4 = Main::isNegative;
        System.out.println(checkPositive4.test(10));

//        BooleanCheck checkPositive5 = number -> PositiveNumber.isPositive(number);
        BooleanCheck checkPositive5 = PositiveNumber::isPositive;
        System.out.println(checkPositive5.check(10));
    }

    public static boolean isNegative(int num){
        return num < 0;
    }
}

@FunctionalInterface
interface BooleanCheck {
    boolean check(int num);
}

class PositiveNumber{
    public static boolean isPositive(int num){
        return num >= 0;
    }
}
