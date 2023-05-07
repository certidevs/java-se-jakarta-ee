package com.example.queue;

import java.io.File;
import java.time.LocalTime;
import java.util.concurrent.BlockingQueue;

public class DirectoryLister extends Thread{

    BlockingQueue<File> queue;
    File directory;
    String extension;

    public DirectoryLister(BlockingQueue<File> queue, File directory, String extension) {
        this.queue = queue;
        this.directory = directory;
        this.extension = extension;
    }

    @Override
    public void run() {

        try {
            listDirectory(directory);
            queue.put(new File("finish"));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void listDirectory(File dir) throws InterruptedException {


        File[] files = dir.listFiles(file -> file.getName().endsWith(extension));
        if (files != null && files.length > 0){
            for (File file : files) {
                queue.put(file);
                System.out.println(LocalTime.now() + " writer added in queue " + file.getAbsolutePath());
            }
        }
    }

}
