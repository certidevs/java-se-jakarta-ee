package com.example.multiple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableDemo {

    public static void main(String[] args) {

        Runnable printHello =  () -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello");
        };


        ExecutorService executor = Executors.newFixedThreadPool(3);
//        ExecutorService executor = Executors.newSingleThreadExecutor();
        System.out.println("begin");
        executor.execute(printHello);
        executor.execute(printHello);
        executor.execute(printHello);
        System.out.println("end");
        executor.shutdown();
        System.out.println(executor.isShutdown());


    }
}
