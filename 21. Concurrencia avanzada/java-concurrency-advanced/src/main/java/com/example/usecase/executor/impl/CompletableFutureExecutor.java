package com.example.usecase.executor.impl;

import com.example.usecase.executor.CustomExecutor;
import com.example.usecase.model.Customer;
import com.example.usecase.model.Dashboard;
import com.example.usecase.model.Order;
import com.example.usecase.model.Product;
import com.example.usecase.service.CustomerService;
import com.example.usecase.service.OrderService;
import com.example.usecase.service.ProductService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CompletableFutureExecutor implements CustomExecutor {

    OrderService orderService;
    CustomerService customerService;
    ProductService productService;

    public CompletableFutureExecutor(OrderService orderService, CustomerService customerService, ProductService productService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }


    @Override
    public void task1(long milliseconds) throws InterruptedException {
        CompletableFuture<Void> cf1 = CompletableFuture.runAsync(() -> this.sleep(milliseconds));
        CompletableFuture<Void> cf2 = CompletableFuture.runAsync(() -> this.sleep(milliseconds));
        CompletableFuture.allOf(cf1, cf2).join();
    }

    @Override
    public Order task2(Long customerId, Long productId) throws InterruptedException {
        CompletableFuture<Product> cf1 = CompletableFuture.supplyAsync(() -> productService.findById(productId));
        CompletableFuture<Customer> cf2 = CompletableFuture.supplyAsync(() -> customerService.findById(customerId));

        return CompletableFuture.allOf(cf1, cf2).thenApplyAsync(unused -> {
            Product product = cf1.join();
            Customer customer = cf2.join();
            return orderService.save(customer.id(), product.id());
        }).join();
    }

    @Override
    public Dashboard task3(Long customerId) throws InterruptedException {
        return null;
    }

}
