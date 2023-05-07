package com.example.single;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableDemo {

    public static void main(String[] args) {
        Runnable printHello =  () -> System.out.println("Hola mundo");

        Runnable printHellos =  () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("Hola mundo " + i);
            }
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("begin");
        executor.execute(printHello);
        executor.execute(printHellos);
        executor.execute(printHello);
        System.out.println("end");
        executor.shutdown();
        System.out.println(executor.isShutdown());

    }
}
