package com.example.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListMain {

    public static void main(String[] args) {

        Queue<Integer> numbers = new LinkedList<>();
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);
        System.out.println("Queue: " + numbers);

        Integer accessedNumber = numbers.peek();
        System.out.println("Accessed Element: " + accessedNumber);

        Integer removedNumber = numbers.poll();
        System.out.println("Removed Element: " + removedNumber);
        System.out.println("Updated Queue: " + numbers);


//        LinkedList<String> names = new LinkedList<>(List.of("name1", "name2", "name3", "name4"));
//        System.out.println(names);
//
//        System.out.println("getFirst: " + names.getFirst());
//        System.out.println("getLast: " + names.getLast());
//
//        names.addFirst("name0");
//        System.out.println(names);
//
//        names.addLast("name5");
//        System.out.println(names);
//
//        names.removeFirst();
//        System.out.println(names);
//
//        names.removeLast();
//        System.out.println(names);
//
//        names.add("name6");
//
//        names.remove();
//        System.out.println(names);


        // Polimorfismo

//        Queue<String> surnames = new LinkedList<>(List.of("surname1", "surname2", "surname3", "surname4"));
//        System.out.println(surnames);
//        String surname = surnames.poll();
//        System.out.println(surname);
//
//        surname = surnames.peek(); // .element() lanza excepción si la cola es nula
//        System.out.println(surname);

    }
}
