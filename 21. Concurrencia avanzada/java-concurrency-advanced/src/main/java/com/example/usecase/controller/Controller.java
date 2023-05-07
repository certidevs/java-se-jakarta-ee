package com.example.usecase.controller;

import com.example.usecase.executor.CustomExecutor;
import com.example.usecase.model.Dashboard;
import com.example.usecase.model.Order;

public class Controller {

    CustomExecutor executor;

    public Controller(CustomExecutor executor) {
        this.executor = executor;
    }

    public void executeTask1(Long time) throws InterruptedException {
        executor.task1(time);
    }

    public Order executeTask2(Long customerId, Long productId) throws InterruptedException {
        return executor.task2(customerId, productId);
    }

    public Dashboard executeTask3(Long customerId) throws InterruptedException {
        return executor.task3(customerId);
    }
}
