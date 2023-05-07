package com.example.pause;

public class Main {

    public static void main(String[] args) {

        Thread hilo = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                System.out.println("Iteración " + i);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        hilo.start();

    }
}
