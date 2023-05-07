package com.example.write;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WriteMain {

    public static void main(String[] args) throws IOException {

        String content = "Lorem ipsum dolor";

        Files.write(Paths.get("src/main/resources/file3.txt"), content.getBytes());

    }
}
