package com.example.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListCreationDemo {

    public static void main(String[] args) {

        // new
        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        System.out.println(names);

        // asList
        String[] namesArray = new String[] {"name1", "name2", "name3"};
        List<String> names2 = Arrays.asList(namesArray);
        System.out.println(names2);
        names2.add("name4");

        // of
        List<String> names3 = List.of("name1", "name2", "name3");
        // names3.add("name4"); // Es un objeto inmutable, no se puede modificar: java.lang.UnsupportedOperationException

        // copyOf
        List<String> names4 = List.copyOf(names);
        names4.add("name4"); // Es un objeto inmutable

        // convertir de inmutable a mutable
        List<String> names5 = new ArrayList<>(List.copyOf(names));
        names5.add("name4"); // Es un objeto inmutable
    }
}
