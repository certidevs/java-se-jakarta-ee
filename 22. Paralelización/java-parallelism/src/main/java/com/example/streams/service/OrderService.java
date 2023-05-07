package com.example.streams.service;


import com.example.streams.model.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();

    List<Order> findAllByCustomerId(Long customerId);

    Order save(Long customerId, Long productId);


}
