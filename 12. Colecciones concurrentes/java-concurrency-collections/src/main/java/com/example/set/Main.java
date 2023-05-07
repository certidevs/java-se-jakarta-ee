package com.example.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class Main {

    public static void main(String[] args) {
//        Set<Integer> numbers = new HashSet<>();
        Set<Integer> numbers = new CopyOnWriteArraySet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        new WriterThread("writer", numbers).start();
        new ReaderThread("reader", numbers).start();
    }
}

class WriterThread extends Thread {

    Set<Integer> numbers;

    public WriterThread(String name, Set<Integer> numbers) {
        super(name);
        this.numbers = numbers;
    }

    @Override
    public void run() {
        int count = numbers.size() + 1;

        while (true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            numbers.add(count++);
            System.out.println(this.getName() + " finished");
        }
    }
}

class ReaderThread extends Thread {

    Set<Integer> numbers;

    public ReaderThread(String name, Set<Integer> numbers) {
        super(name);
        this.numbers = numbers;
    }

    @Override
    public void run() {
        while (true){
            StringBuilder output = new StringBuilder("\n" + this.getName() + ":");
            Iterator<Integer> iterator = numbers.iterator();
            while(iterator.hasNext()){
                Integer next = iterator.next();
                output.append(" ").append(next);

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println(output);
        }
    }
}