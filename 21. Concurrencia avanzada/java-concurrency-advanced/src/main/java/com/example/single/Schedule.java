package com.example.single;

import java.util.concurrent.*;

public class Schedule {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> hello = () -> "hello";
        Callable<String> bye = () -> "bye";
        Runnable finish = () -> System.out.println("finish");

        var executor = Executors.newSingleThreadScheduledExecutor();

        ScheduledFuture<String> future1 = executor.schedule(hello, 5, TimeUnit.SECONDS);
        System.out.println(future1.get());

        ScheduledFuture<String> future2 = executor.schedule(bye, 10, TimeUnit.SECONDS);
        System.out.println(future2.get());

        executor.scheduleWithFixedDelay(finish, 0, 5, TimeUnit.SECONDS); // la ejecuta cada 5 segundos
        Thread.sleep(30000);
        executor.shutdown();

    }
}
