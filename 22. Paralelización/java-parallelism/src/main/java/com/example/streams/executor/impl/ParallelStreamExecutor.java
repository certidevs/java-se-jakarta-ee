package com.example.streams.executor.impl;

import com.example.streams.executor.*;
import com.example.streams.model.*;
import com.example.streams.service.*;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class ParallelStreamExecutor implements CustomExecutor {

    OrderService orderService;
    CustomerService customerService;
    ProductService productService;

    public ParallelStreamExecutor(OrderService orderService, CustomerService customerService, ProductService productService) {
        this.orderService = orderService;
        this.customerService = customerService;
        this.productService = productService;
    }


    @Override
    public void task1(long milliseconds) throws InterruptedException {
//        List.of().parallelStream();
//        List.of().stream().parallel()
        Stream.of(1, 2).parallel().forEach(num -> this.sleep(milliseconds));
    }

    @Override
    public Order task2(Long customerId, Long productId) throws InterruptedException {
        Map<Function, Object> commands = new HashMap<>();

        Function customerCommand = custId -> customerService.findById((Long) custId); // return Customer
        Function productCommand = prodId -> productService.findById((Long) prodId); // return Product

        commands.put(customerCommand, customerId);
        commands.put(productCommand, productId);

        List<Object> results = Stream.of(customerCommand, productCommand)
                .parallel()
                .map(command -> {
                    Object id = commands.get(command);
                    return command.apply(id);
                })
                .toList();

        Customer customer = (Customer) results.get(0);
        Product product = (Product) results.get(1);

        if (Objects.nonNull(product) && Objects.nonNull(customer))
            return orderService.save(product.id(), customer.id());

        throw new RuntimeException("No se ha podido crear el pedido");
    }

    @Override
    public Dashboard task3(Long customerId) throws InterruptedException {
        Map<Function, Object> commands = new HashMap<>();

        Function customerCommand = custId -> customerService.findById((Long) custId); // return Customer
        Function productCommand = prodId -> productService.findAll(); // return Products
        Function orderCommand = custId -> orderService.findAllByCustomerId((Long) custId); // return Orders

        commands.put(customerCommand, customerId);
        commands.put(productCommand, null);
        commands.put(orderCommand, customerId);

        List<Object> results = Stream.of(customerCommand, orderCommand, productCommand)
                .parallel()
                .map(command -> command.apply(commands.get(command)))
                .toList();

        try {
            Customer customer = (Customer) results.get(0);
            List<Order> orders = (List<Order>) results.get(1);
            Set<Product> products = (Set<Product>) results.get(2);
            return new Dashboard(customer, orders, products);
        }catch(Exception e){
            throw new RuntimeException("No se ha podido obtener el dashboard");
        }
    }
}
