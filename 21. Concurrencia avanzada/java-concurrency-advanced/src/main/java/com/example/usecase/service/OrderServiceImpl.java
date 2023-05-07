package com.example.usecase.service;

import com.example.usecase.model.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OrderServiceImpl implements OrderService{

    private final Map<Long, Order> orders = new HashMap<>();

    @Override
    public Order save(Long customerId, Long productId) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Order order = new Order(customerId, productId);
        orders.put(customerId, order);
        return order;
    }

    @Override
    public List<Order> findAllByCustomerId(Long customerId) {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return orders.keySet().stream()
                .filter(id -> Objects.equals(id, customerId))
                .map(orders::get)
                .toList();
    }

    @Override
    public List<Order> findAll() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return orders.keySet().stream()
                .map(orders::get)
                .toList();
    }
}
