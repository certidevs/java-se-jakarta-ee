package com.example.polling;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static List<String> messages = List.of("message1", "message2", "message3", "message4");
    static long patience = 8000;

    public static void main(String[] args) throws InterruptedException {

        Thread.currentThread().setName("thread1");

        long startTime = System.currentTimeMillis();

        Thread thread2 = new Thread(() -> {
            Thread.currentThread().setName("thread2");
            print("Iniciando trabajo");
            try {
                for(String msg: messages){
                    Thread.sleep(4000);
                    print(msg);
                }
                print("Fin de las tareas");
            } catch (InterruptedException e) {
                print("Hilo parado");
            }
        });
        thread2.start();


        while(thread2.isAlive()){
            print("continúo esperando");
            thread2.join(1000L);
            long endTime = System.currentTimeMillis();
            long elapsed = endTime - startTime;
            if (elapsed > patience && thread2.isAlive()){
                print("No espero más !");
                thread2.interrupt();
                thread2.join();
            }
        }
        print("fin");

    }

    static void print(String message){
        String threadName = Thread.currentThread().getName();
        System.out.format("%s: %s%n", threadName, message);
    }
}
