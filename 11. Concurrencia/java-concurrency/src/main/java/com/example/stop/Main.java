package com.example.stop;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread hilo = new Thread(() -> {
            for (int i = 0; i < 5; i++){
                System.out.println("Iteración " + i);

//                if(Thread.interrupted()){
//                    System.out.println("I'm resumed");
//                    return;
//                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("I'm resumed");
                    return;
                }

                if(Thread.interrupted()){
                    System.out.println("I'm resumed");
                    return;
                }
            }
        });
        hilo.start();

        Thread.sleep(5000L); // pausa

//        if (hilo.isAlive())
        hilo.interrupt();

    }
}
