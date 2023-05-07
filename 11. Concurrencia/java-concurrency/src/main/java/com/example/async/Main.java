package com.example.async;

public class Main {

    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> System.out.println("Hola1"));
        Thread thread2 = new Thread(() -> System.out.println("Hola2"));
        Thread thread3 = new Thread(() -> System.out.println("Hola3"));

        // asíncrono
//        System.out.println("inicio");
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        System.out.println("fin");

        // síncrono: el hilo principal queda bloqueado hasta que terminen los hilos
        System.out.println("inicio");
        thread1.run();
        thread2.run();
        thread3.run();
        System.out.println("fin");
    }
}
