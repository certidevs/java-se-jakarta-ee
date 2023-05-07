package com.example.create.way1;

public class CustomThread extends Thread{
    @Override
    public void run() {
        System.out.println("My name is " + this.getName() + " , state: " + this.getState());
    }
}
