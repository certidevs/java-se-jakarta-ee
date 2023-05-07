package com.example.blockingqueue;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueDemo {

    public static void main(String[] args) {

        LinkedBlockingQueue<String> animals = new LinkedBlockingQueue<>(5);

        // Using add()
        animals.add("Dog");
        animals.add("Cat");

        // Using offer()
        animals.offer("Horse");
        System.out.println("LinkedBlockingQueue: " + animals);


        animals = new LinkedBlockingQueue<>(5);

        // Add elements
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        System.out.println("LinkedBlockingQueue: " + animals);

        // Using peek()
        String element = animals.peek();
        System.out.println("Accessed Element: " + element);

        // Using iterator()
        Iterator<String> iterate = animals.iterator();
        System.out.print("LinkedBlockingQueue Elements: ");

        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }

        animals = new LinkedBlockingQueue<>(5);

        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        System.out.println("LinkedBlockingQueue " + animals);

        // Using remove()
        String element1 = animals.remove();
        System.out.println("Removed Element:");
        System.out.println("Using remove(): " + element1);

        // Using poll()
        String element2 = animals.poll();
        System.out.println("Using poll(): " + element2);

        // Using clear()
        animals.clear();
        System.out.println("Updated LinkedBlockingQueue " + animals);


        animals = new LinkedBlockingQueue<>(5);

        try {
            // Add elements to animals
            animals.put("Dog");
            animals.put("Cat");
            System.out.println("LinkedBlockingQueue: " + animals);
        }
        catch(Exception e) {
            System.out.println(e);
        }


        animals = new LinkedBlockingQueue<>(5);

        try {
            //Add elements to animals
            animals.put("Dog");
            animals.put("Cat");
            System.out.println("LinkedBlockingQueue: " + animals);

            // Remove an element
            element = animals.take();
            System.out.println("Removed Element: " + element);
            System.out.println("New LinkedBlockingQueue: " + animals);
        }
        catch(Exception e) {
            System.out.println(e);
        }

    }
}
