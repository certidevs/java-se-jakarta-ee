package com.example.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListOperations {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        names.add("name4");
        System.out.println(names);

        // removeIf
//        boolean result = names.removeIf(name -> name.startsWith("n"));
        boolean result = names.removeIf(name -> name.contains("2"));
        System.out.println(result);
        System.out.println(names);

        // forEach
        names.forEach(System.out::println);

            // equivalente con iterator
//        Iterator<String> iter = names.iterator();
//        while(iter.hasNext()){
//            String str = iter.next();
//            System.out.println(str);
//        }

        // replaceAll()
        names.replaceAll(name -> "@".concat(name));
        names.replaceAll("@"::concat);

        System.out.println(names);
    }
}
