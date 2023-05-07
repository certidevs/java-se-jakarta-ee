package com.example;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeMain {

    public static void main(String[] args) {

        LocalTime time1 = LocalTime.now();
        System.out.println(time1);

        LocalTime entryHour = LocalTime.of(10, 30);
        System.out.println(entryHour);

        LocalTime entryHourAndSecond = LocalTime.of(10, 30, 15);
        System.out.println(entryHourAndSecond);

        time1.getHour();
        time1.getMinute();
        time1.getSecond();

        // parse
        System.out.println(LocalTime.parse("13:45:16"));

        LocalTime start = LocalTime.now();
        LocalTime end = LocalTime.now().plusHours(1).plusMinutes(30);
        System.out.println(start.isBefore(end)); // true
        System.out.println(start.isAfter(end)); // false

        long minutes = ChronoUnit.MINUTES.between(start, end);
        System.out.println(minutes); // 90

    }
}
