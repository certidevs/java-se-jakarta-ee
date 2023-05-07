package com.example.streams.executor.impl;

import com.example.streams.model.Dashboard;
import com.example.streams.model.Order;
import com.example.streams.service.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamExecutorTest {

    OrderService orderService;
    CustomerService customerService;
    ProductService productService;



    @Test
    void task1() throws InterruptedException {
        orderService = new OrderServiceImpl();
        customerService = new CustomerServiceImpl();
        productService = new ProductServiceImpl();
        var executor = new ParallelStreamExecutor(orderService,
                customerService, productService);

        executor.task1(2000L);
    }

    @Test
    void task2() throws InterruptedException {

        orderService = new OrderServiceImpl();
        customerService = new CustomerServiceImpl();
        productService = new ProductServiceImpl();
        var executor = new ParallelStreamExecutor(orderService,
                customerService, productService);

        customerService.save(1L, "customer1");
        productService.save(1L, "product1", 9.99);

        Order order = executor.task2(1L, 1L);
        assertEquals(1L, order.customerId());
        assertEquals(1L, order.productId());

    }

    @Test
    void task3() throws InterruptedException {

        orderService = new OrderServiceImpl();
        customerService = new CustomerServiceImpl();
        productService = new ProductServiceImpl();
        var executor = new ParallelStreamExecutor(orderService,
                customerService, productService);

        customerService.save(1L, "customer1");
        productService.save(1L, "product1", 9.99);
        productService.save(2L, "product2", 9.99);
        orderService.save(1L, 1L);
        orderService.save(1L, 2L);

        Dashboard dashboard = executor.task3(1L);
    }
}