package com.example.creation;

import java.util.ArrayList;
import java.util.List;

public class StreamsList {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name3");
        long numNames = names.stream().count();
        System.out.println(numNames);

    }
}
