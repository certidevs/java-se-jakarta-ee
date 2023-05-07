package com.example.queue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class FileParser extends Thread {
    BlockingQueue<File> queue;
    String keyword;

    public FileParser(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }

    @Override
    public void run() {
        while (true) {
            try {
                File file = queue.peek();
                if (file != null && !file.getName().equals("finish")) {

                    file = queue.take();

                    System.out.println(LocalTime.now() + " " + this.getName() +
                            " delete file from queue " + file.getAbsolutePath() + " queue size: " + queue.size());

                    searchKeywordInFile(file);
                }
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void searchKeywordInFile(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int lineNumber = 0;
        for (String line : lines) {
            lineNumber++;
            if (line.contains(keyword)){
                String result = LocalTime.now() + " " + this.getName() + " keyword " +
                        keyword + " found at line " + lineNumber + " in file " + file.getAbsolutePath();
                System.out.println(result);
                break; // opcional, romper el bucle
            }
        }
    }
}
