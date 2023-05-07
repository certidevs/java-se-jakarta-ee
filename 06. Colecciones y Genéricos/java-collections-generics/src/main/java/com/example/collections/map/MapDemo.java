package com.example.collections.map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main(String[] args) {

        Map<String, String> names1 = new HashMap<>();
        names1.put("key1", "value1");
        names1.put("key1", "value2"); // remplaza
        names1.put("key1", "value3"); // remplaza
        System.out.println(names1);

        Map<Long, String> names2 = Map.of(1L, "value1", 2L, "value2", 3L, "value3");

        Map<Long, String> names3 = Map.of(
                1L, "value1",
                2L, "value2",
                3L, "value3",
                4L, "value4"
        );

        Map<Long, String> names4 = Map.ofEntries(
                Map.entry(1L, "value1"),
                Map.entry(2L, "value2"),
                Map.entry(3L, "value3")
        );


    }
}
