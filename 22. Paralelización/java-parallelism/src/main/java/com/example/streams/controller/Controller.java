package com.example.streams.controller;

import com.example.streams.executor.*;
import com.example.streams.model.*;
import com.example.streams.service.*;

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
