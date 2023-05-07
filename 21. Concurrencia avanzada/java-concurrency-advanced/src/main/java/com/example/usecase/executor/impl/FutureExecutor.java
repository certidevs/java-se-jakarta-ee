package com.example.usecase.executor.impl;

import com.example.usecase.executor.CustomExecutor;
import com.example.usecase.model.Customer;
import com.example.usecase.model.Dashboard;
import com.example.usecase.model.Order;
import com.example.usecase.model.Product;
import com.example.usecase.service.CustomerService;
import com.example.usecase.service.OrderService;
import com.example.usecase.service.ProductService;

import java.util.*;
import java.util.concurrent.*;

public class FutureExecutor implements CustomExecutor {

    OrderService orderService;
    CustomerService customerService;
    ProductService productService;

    public FutureExecutor(OrderService orderService, CustomerService customerService, ProductService productService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }

    @Override
    public void task1(long milliseconds) throws InterruptedException {
        Thread thread1 = new Thread(() -> this.sleep(milliseconds));
        Thread thread2 = new Thread(() -> this.sleep(milliseconds));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    @Override
    public Order task2(Long customerId, Long productId) throws InterruptedException {
        var executor = Executors.newFixedThreadPool(2);

        Callable<Customer> customerCall = () -> customerService.findById(customerId);
        Callable<Product> productCall = () -> productService.findById(productId);

        List tasks = List.of(customerCall, productCall);
        List<Future<Object>> responses = executor.invokeAll(tasks);

        try {
            Customer customer = (Customer) responses.get(0).get();
            Product product = (Product) responses.get(1).get();

            if (Objects.nonNull(customer) && Objects.nonNull(product))
                return orderService.save(customerId, productId);

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        throw new RuntimeException("No se ha podido crear el pedido");
    }

    @Override
    public Dashboard task3(Long customerId) throws Exception {
        var executor = Executors.newFixedThreadPool(2);

        Callable<Customer> customerCall = () -> customerService.findById(customerId);
        Callable<List<Order>> orderCall = () -> orderService.findAllByCustomerId(customerId);
        Callable<Set<Product>> productCall = () -> productService.findAll();

        Customer customer;
        Set<Product> products;
        List<Order> orders;

        customer = customerCall.call();

        List tasks = List.of(orderCall, productCall);
        List<Future<Object>> responses = executor.invokeAll(tasks);
        executor.shutdown();

        try{
            orders = (List<Order>) responses.get(0).get();
        }catch(Exception e){
            orders = new ArrayList<>();
        }
        try{
            products = (Set<Product>) responses.get(1).get();
        }catch(Exception e){
            products = new HashSet<>();
        }
        return new Dashboard(customer, orders, products);

    }
}
