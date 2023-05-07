package com.example.queue;

import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        String dir = "C:\\data";
        String extension = ".txt";
        String keyword = "java";

        BlockingQueue<File> queue = new ArrayBlockingQueue<>(100);

        DirectoryLister lister = new DirectoryLister(queue, new File(dir), extension);
        lister.start();

        Thread.sleep(500);

        for (int i = 0; i < 10; i++) {
            FileParser parser = new FileParser(queue, keyword);
            parser.start();
        }
    }
}
