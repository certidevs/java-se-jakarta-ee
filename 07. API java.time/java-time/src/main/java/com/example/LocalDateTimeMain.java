package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LocalDateTimeMain {

    public static void main(String[] args) {


        LocalDateTime dateTime1 = LocalDateTime.of(2022, 1, 1, 15, 40, 23);
        System.out.println(dateTime1);

        LocalDateTime dateTime2 = LocalDateTime.of(
                LocalDate.of(2022, 1, 1),
                LocalTime.of(10, 40, 13)
        );
        System.out.println(dateTime2);

        LocalDate date1 = dateTime2.toLocalDate();
        LocalTime time1 = dateTime2.toLocalTime();

        System.out.println(dateTime2.withHour(12));


    }
}
