package com.example.usecase.executor;

import com.example.usecase.model.Dashboard;
import com.example.usecase.model.Order;

public interface CustomExecutor {

    void task1(long milliseconds) throws InterruptedException;

    Order task2(Long customerId, Long productId) throws InterruptedException;

    Dashboard task3(Long customerId) throws Exception;


    default void sleep(long timeToSleep) {
        System.out.println("Ejecutando Thread.sleep");
        try {
            Thread.sleep(timeToSleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
