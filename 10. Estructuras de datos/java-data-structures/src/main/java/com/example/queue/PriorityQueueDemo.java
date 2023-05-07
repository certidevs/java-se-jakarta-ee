package com.example.queue;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueDemo {


    public static void main(String[] args) {

        Queue<Integer> numbers = new PriorityQueue<>();
        numbers.offer(1);
        numbers.offer(2);
        numbers.offer(3);
        System.out.println("Queue: " + numbers);

        Integer accessedNumber = numbers.peek();
        System.out.println("Accessed Element: " + accessedNumber);

        Integer removedNumber = numbers.poll();
        System.out.println("Removed Element: " + removedNumber);
        System.out.println("Updated Queue: " + numbers);

        boolean result = numbers.remove(1);
        System.out.println("Is the element 1 removed? " + result);

//        // Priority Queue
//        PriorityQueue<String> sortedNames = new PriorityQueue<>(Comparator.comparingInt(String::length));
//        sortedNames.addAll(List.of("Juan", "Anastasia", "Mikel", "Antonio"));
//        System.out.println(sortedNames);

    }
}
