package com.example.blockingqueue;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*

capacity indica el tamaño
add()
offer()
peek()
iterator()


 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) {

        BlockingQueue<Integer> numbers = new ArrayBlockingQueue<>(5);

        try {
            numbers.put(2);
            numbers.put(1);
            numbers.put(3);
            System.out.println("BLockingQueue: " + numbers);

            int removedNumber = numbers.take();
            System.out.println("Removed Number: " + removedNumber);

        } catch (Exception e) {
            e.getStackTrace();
        }

        ArrayBlockingQueue<String> animals = new ArrayBlockingQueue<>(5);

        // Using add()
        animals.add("Dog");
        animals.add("Cat");

        // Using offer()
        animals.offer("Horse");
        System.out.println("ArrayBlockingQueue: " + animals);

        // Using iterator()
        Iterator<String> iterate = animals.iterator();
        System.out.print("ArrayBlockingQueue Elements: ");

        while(iterate.hasNext()) {
            System.out.print(iterate.next());
            System.out.print(", ");
        }

        animals.forEach(System.out::println);
        animals.iterator().forEachRemaining(System.out::println);


        animals = new ArrayBlockingQueue<>(5);

        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");
        System.out.println("ArrayBlockingQueue: " + animals);

        // Using remove()
        String element1 = animals.remove();
        System.out.println("Removed Element:");
        System.out.println("Using remove(): " + element1);

        // Using poll()
        String element2 = animals.poll();
        System.out.println("Using poll(): " + element2);

        // Using clear()
        animals.clear();
        System.out.println("Updated ArrayBlockingQueue: " + animals);

    }
}
