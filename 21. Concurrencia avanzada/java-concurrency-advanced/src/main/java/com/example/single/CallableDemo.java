package com.example.single;

import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable<Integer> task = () -> {
            Thread.sleep(3000L);
            return 50 + 50;
        };
        Future<Integer> future = executor.submit(task);
        Integer result = future.get(2, TimeUnit.SECONDS); // si se supera entonces produce TimeoutException
        System.out.println(result);
        System.out.println("fin");
        executor.shutdown();

    }
}
