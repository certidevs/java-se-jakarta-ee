package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.stream.Stream;

public class LocalDateMain {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate birthDate = LocalDate.of(1900, Month.JULY, 11);
        System.out.println(birthDate);

        LocalDate date1 = LocalDate.ofYearDay(2010, 90);
        System.out.println(date1);

        // operaciones

        LocalDate expirationDate = today.plusDays(14);
        System.out.println(expirationDate);

        today.plusWeeks(2);
        today.plusMonths(3);

        today.minusMonths(3);
        // ....

        // extraer información
        today.getYear();
        today.getMonth();
        today.getDayOfWeek().getValue();

        today.get(ChronoField.DAY_OF_MONTH);

        // parse
        LocalDate date2 = LocalDate.parse("2015-12-23");
        System.out.println(date2);

        Stream.iterate(date2, d -> d.plusMonths(1))
                .map(LocalDate::getMonth)
                .limit(14)
                .forEach(System.out::println);


    }
}
