package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

public class PeriodMain {

    public static void main(String[] args) {

        LocalDate init = LocalDate.of(2020, Month.JANUARY, 1);
        LocalDate end = LocalDate.of(2025, Month.NOVEMBER, 15);
        System.out.println(Period.between(init, end).getYears());
    }
}
