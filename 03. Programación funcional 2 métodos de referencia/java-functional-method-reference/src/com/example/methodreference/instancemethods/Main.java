package com.example.methodreference.instancemethods;

import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        PositiveNumber positiveNumber = new PositiveNumber();

        // lambda
        Predicate<Integer> predicate1 = num -> positiveNumber.isPositive(num);
        System.out.println(predicate1.test(10));

        // method reference. El método no es estático por lo que se ha creado un objeto
        Predicate<Integer> predicate2 = positiveNumber::isPositive;

    }

}

class PositiveNumber{
    public boolean isPositive(int num){
        return num >= 0;
    }
}


