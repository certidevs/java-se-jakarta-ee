package com.example.wait;

public class Main {

    public static void main(String[] args) throws InterruptedException {


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

        hilo.join(); // espera a que termine el hilo antes de continuar

        System.out.println("My name is " + Thread.currentThread().getName()
                + " , state: " + Thread.currentThread().getState());



    }
}
