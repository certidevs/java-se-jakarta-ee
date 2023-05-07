package com.example.forkjoin;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest {

    @Test
    void test1() {
        Random random = new Random();
        int[] numbers = new int[50];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(35);
        }

        RecursiveTask<Integer> task = new CustomRecursiveTask(numbers);

        ForkJoinPool pool = ForkJoinPool.commonPool();

        pool.execute(task);
        System.out.println(task.join());


    }
}
