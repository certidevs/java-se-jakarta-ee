package com.example.creation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamEmpty {

    public static void main(String[] args) {

        Stream<String> namesStream = Stream.empty();

        List<String> names2 = new ArrayList<>();
        names2.add("name1");
        names2.add("name2");
        names2.add("name3");
        Stream<String> namesStream2 = names2.stream();

        Stream<String> names = Stream.concat(namesStream, namesStream2);
    }
}
