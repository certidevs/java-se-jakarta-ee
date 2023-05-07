package com.example.operacionesintermedias;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static void main(String[] args) {

        List<String> texts = new ArrayList<>();
        texts.add("ddd2");
        texts.add("aaa2");
        texts.add("bbb1");
        texts.add("aaa1");
        texts.add("bbb3");
        texts.add("ccc");
        texts.add("bbb2");

//        texts.stream().filter(text -> text.startsWith("a")).forEach(System.out::println);

        texts.stream()
                .filter(text -> text.startsWith("a"))
                // ... aquí podría haber otros procesamientos ...
                .filter(text -> text.endsWith("2"))
                .forEach(System.out::println);

    }
}
