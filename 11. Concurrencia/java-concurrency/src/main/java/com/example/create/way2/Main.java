package com.example.create.way2;

public class Main {

    public static void main(String[] args) {

        Runnable task = new CustomRunnable();
        Thread hilo = new Thread(task);
        hilo.start();

        System.out.println("My name is " + Thread.currentThread().getName()
                + " , state: " + Thread.currentThread().getState());
    }
}
