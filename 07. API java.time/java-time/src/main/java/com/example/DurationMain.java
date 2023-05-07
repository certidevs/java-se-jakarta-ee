package com.example;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;

public class DurationMain {

    public static void main(String[] args) {

        LocalDateTime init = LocalDateTime.of(2020, Month.JANUARY, 1, 14, 30);
        LocalDateTime end = LocalDateTime.of(2020, Month.NOVEMBER, 15, 14, 30);
        long days = Duration.between(init, end).toDays();
        System.out.println(days);


    }
}
