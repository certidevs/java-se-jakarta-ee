package com.example.usecase.model;

import java.util.List;
import java.util.Set;

public record Dashboard(Customer customer, List<Order> orders, Set<Product> products) {
}
