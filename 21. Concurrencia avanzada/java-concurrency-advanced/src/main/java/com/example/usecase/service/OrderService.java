package com.example.usecase.service;

import com.example.usecase.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    List<Order> findAllByCustomerId(Long customerId);

    Order save(Long customerId, Long productId);


}
