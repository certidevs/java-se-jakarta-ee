package com.example.list;

import java.util.Stack;

/*
LIFO: Last In First Out

En vez de Stack es mejor utilizar Deque<Integer> stack = new ArrayDeque<Integer>()
 */
public class StackDemo {

    public static void main(String[] args) {
        Stack<String> names = new Stack<>();

        names.push("Hola");
        names.push("mundo");
        names.push("Adios.");

        System.out.println(names.get(0));

        System.out.println(names.peek());

        System.out.println(names.search("mundo"));

        System.out.println("\nBorrados:  ");
        System.out.println(names.pop()); // el último que entra es el primero que sale
        System.out.println(names.pop());


    }
}
