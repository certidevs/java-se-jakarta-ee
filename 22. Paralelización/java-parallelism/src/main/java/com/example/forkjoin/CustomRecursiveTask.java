package com.example.forkjoin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class CustomRecursiveTask extends RecursiveTask<Integer> {

    int[] numbers;
    static final int THRESHOLD = 20;

    public CustomRecursiveTask(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    protected Integer compute() {
        if (numbers.length > THRESHOLD) {
            return ForkJoinTask
                    .invokeAll(createSubTasks())
                    .stream()
                    .mapToInt(ForkJoinTask::join)
                    .sum();
        } else {
            return processing(numbers);
        }
    }

    private Collection<CustomRecursiveTask> createSubTasks() {
        List<CustomRecursiveTask> subtasks = new ArrayList<>();
        // subtarea para la primera mitad
        subtasks.add(new CustomRecursiveTask(Arrays.copyOfRange(numbers, 0, numbers.length / 2)));
        // subtarea para la segunda mitad
        subtasks.add(new CustomRecursiveTask(Arrays.copyOfRange(numbers, numbers.length / 2, numbers.length)));
        return subtasks;
    }

    private Integer processing(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
