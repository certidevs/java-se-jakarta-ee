package com.example.map;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) {
//        Map<Integer, String> numbers = new HashMap<>();
        Map<Integer, String> numbers = new ConcurrentHashMap<>();
        new WriterThread("writer1", numbers, 1).start();
        new WriterThread("writer2", numbers, 2).start();

        for (int i = 1; i <= 5; i++) {
            new ReaderThread("reader" + i, numbers).start();
        }
    }


}

class WriterThread extends Thread {
    Map<Integer, String> numbers;
    Random random;

    public WriterThread(String name, Map<Integer, String> numbers, long seed) {
        super(name);
        this.numbers = numbers;
        this.random = new Random(seed);
    }

    @Override
    public void run() {
        while (true) {

            Integer key = random.nextInt(10);
            String value = this.getName();

            if (numbers.putIfAbsent(key, value) == null){
                System.out.format("%s: %s has put key %d \n", LocalTime.now(), this.getName(), key);
            }

            Integer keyToRemove = random.nextInt(10);
            if(numbers.remove(keyToRemove, value)){
                System.out.format("%s: %s has removed key %d \n", LocalTime.now(), this.getName(), keyToRemove);
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

class ReaderThread extends Thread {

    Map<Integer, String> numbers;

    public ReaderThread(String name, Map<Integer, String> numbers) {
        super(name);
        this.numbers = numbers;
    }

    @Override
    public void run() {
        while(true){
            Iterator<Integer> iterator = numbers.keySet().iterator();
            StringBuilder output = new StringBuilder(LocalTime.now() + ": " + this.getName() + ":");

            while(iterator.hasNext()){
                Integer key = iterator.next();
                String value = numbers.get(key);
                output.append(key).append("=>").append(value).append("; ");
            }

            System.out.println(output);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}