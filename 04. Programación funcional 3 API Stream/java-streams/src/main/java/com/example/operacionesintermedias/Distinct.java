package com.example.operacionesintermedias;

import java.util.ArrayList;
import java.util.List;

public class Distinct {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(2);

        System.out.println(numbers.size());
        System.out.println(numbers);

        long num = numbers.stream().distinct().count();
        System.out.println(num);


    }
}
