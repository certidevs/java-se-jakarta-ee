package com.example.list;

import java.util.Vector;

public class VectorDemo {

    public static void main(String[] args) {

        Vector<String> names = new Vector<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");

        System.out.println(names.get(1));

        names.remove(1);


    }
}
