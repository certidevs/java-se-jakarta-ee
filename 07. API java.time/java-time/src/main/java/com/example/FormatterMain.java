package com.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatterMain {

    public static void main(String[] args) {

        // pasar de fecha a texto
        String pattern = "dd/MM/YYYY";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

        LocalDate date1 = LocalDate.now(); // YYYY-MM-dd
        String date1Text = date1.format(formatter);
        System.out.println(date1Text);

        // Pasar de texto a fecha

        String date = "16-Aug-2016";
        System.out.println(Locale.getDefault());
        LocalDate date2 = LocalDate.parse(date, DateTimeFormatter.ofPattern("d-MMM-yyyy", Locale.US));
        System.out.println(date2);
    }
}
