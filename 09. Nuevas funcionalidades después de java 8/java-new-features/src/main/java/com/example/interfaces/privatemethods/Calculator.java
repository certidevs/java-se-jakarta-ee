package com.example.interfaces.privatemethods;

public interface Calculator {


    double IVA = 0.21;

    default double sumPrices(double price1, double price2){
        double totalPrice1 = price1 + calculateIVA(price1);
        double totalPrice2 = price2 + calculateIVA(price2);
        return totalPrice1 + totalPrice2;
    }

    private double calculateIVA(double price){
        return price * IVA;
    }
}
