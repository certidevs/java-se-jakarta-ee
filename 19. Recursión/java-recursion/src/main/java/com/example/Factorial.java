package com.example;

import java.time.Duration;
import java.time.Instant;

public class Factorial {

    public static void main(String[] args) {
        Long number = 20L;
        long start = System.currentTimeMillis();
        long result = factorialIterative(number);
        long end = System.currentTimeMillis();
        System.out.println("Tiempo: " + (end - start) + ", Resultado: " + result);

        number = 20L;
        start = System.currentTimeMillis();
        result = factorialRecursive(number);
        end = System.currentTimeMillis();
        System.out.println("Tiempo: " + (end - start) + ", Resultado: " + result);

        number = 20L;
        start = System.currentTimeMillis();
        result = factorialRecursiveTail(number);
        end = System.currentTimeMillis();
        System.out.println("Tiempo: " + (end - start) + ", Resultado: " + result);

    }

    static long factorialIterative(Long num){
        long result = 1;
        for(int i = 1; i<=num; i++)
            result *= i;

        return result;
    }

    static long factorialRecursive(Long num){
        if(num == 1)
            return 1;
        return num * factorialRecursive(num - 1);
    }

    // Versión mejorada de la recusión: recursión de cola

    static long factorialRecursiveTail(Long num){
        return factorialHelper(1, num);
    }

    static long factorialHelper(long acumulador, Long num){
        if (num == 1)
            return acumulador;
        return factorialHelper(acumulador * num, num - 1);
    }

}
