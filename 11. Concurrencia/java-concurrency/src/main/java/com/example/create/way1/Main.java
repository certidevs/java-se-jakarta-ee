package com.example.create.way1;

public class Main {
    public static void main(String[] args) {

        Thread hilo1 = new CustomThread();
        hilo1.start();
        Thread hilo2 = new CustomThread();
        hilo2.start();

        System.out.println("My name is " + Thread.currentThread().getName()
                + " , state: " + Thread.currentThread().getState());
    }
}
