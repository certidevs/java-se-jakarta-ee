package com.example.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        // Creating Deque using the ArrayDeque class
        Deque<Integer> numbers = new LinkedList<>();

        // add elements to the Deque
        numbers.offer(1);
        numbers.offerLast(2);
        numbers.offerFirst(3);
        System.out.println("Deque: " + numbers);

        // Access elements of the Deque
        Integer firstElement = numbers.peekFirst();
        System.out.println("First Element: " + firstElement);

        Integer lastElement = numbers.peekLast();
        System.out.println("Last Element: " + lastElement);

        // Remove elements from the Deque
        Integer removedNumber1 = numbers.pollFirst();
        System.out.println("Removed First Element: " + removedNumber1);

        Integer removedNumber2 = numbers.pollLast();
        System.out.println("Removed Last Element: " + removedNumber2);

        System.out.println("Updated Deque: " + numbers);
    }
}
