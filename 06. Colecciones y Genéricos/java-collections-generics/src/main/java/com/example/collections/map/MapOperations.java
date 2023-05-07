package com.example.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapOperations {

    public static void main(String[] args) {

        Map<Long, String> employees = Map.of(1L, "Bob", 2L, "Patry", 3L, "Mike");

        employees.values();
        employees.keySet();
        employees.entrySet();

        employees.forEach((key, value) -> System.out.println("key: " + key + ", value: " + value));
        employees.values().forEach(System.out::println);

        employees.get(1L);
        employees.getOrDefault(999L, "default");

        Map<String, String> names1 = new HashMap<>();
        names1.put("key1", "value1");
        names1.put("key2", "value2");
        names1.put("key3", "value3");

        names1.putIfAbsent("key3", "value4");
        System.out.println(names1);

        Map<String, String> cars = new HashMap<>();
        cars.put("Honda", "Civic");
        cars.put("Ford", "Fiesta");
        System.out.println(cars);

        cars.replaceAll((key, value) -> key.concat(" ").concat(value));
        System.out.println(cars);


    }
}
