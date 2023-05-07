package com.example.create.way2;

public class CustomRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("My name is " + Thread.currentThread().getName()
                + " , state: " + Thread.currentThread().getState());    }
}
