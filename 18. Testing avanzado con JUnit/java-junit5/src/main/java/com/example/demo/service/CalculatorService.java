package com.example.demo.service;

public class CalculatorService {

    public int sum(int num1, int num2){
        if(num1 < 0 || num2 < 0)
            return 0;
        return num1 + num2;
    }

}
