package com.example;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
A partir de Java 8 se incorpora la api java.time
 */
public class OldWay {

    public static void main(String[] args) {

        Date date = new GregorianCalendar(2022, Calendar.JANUARY, 11).getTime();
        System.out.println(date);
    }
}
