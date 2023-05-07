package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.stream.Stream;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        HelloService service = new HelloService();
        service.info();
        service.warn();
        service.error();
        service.debug();
        service.trace();

        Stream.iterate(1, num -> num + 1)
                .limit(1000)
                .forEach(num -> logger.warn("iteracion " + num));

    }
}
