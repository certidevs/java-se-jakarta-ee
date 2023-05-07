package com.example.streams.executor;


import com.example.streams.model.Dashboard;
import com.example.streams.model.Order;

public interface CustomExecutor {

    void task1(long milliseconds) throws InterruptedException;

    Order task2(Long customerId, Long productId) throws InterruptedException;

    Dashboard task3(Long customerId) throws InterruptedException;


    default void sleep(long timeToSleep) {
        System.out.println("Ejecutando Thread.sleep");
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
