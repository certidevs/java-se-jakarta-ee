package com.example.createfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public class CreateFileMain {

    public static void main(String[] args) throws IOException {

        // java io

        File file = new File("src/main/resources/file1.txt");
        System.out.println("File exists: " + file.exists());

//        boolean created = file.createNewFile();
//        System.out.println(created);

        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Is Directory: " + file.isDirectory());
        System.out.println("Is File: " + file.isFile());
        System.out.println("Parent: " + file.getParent());


        // java nio
        Path path = Path.of("src/main/resources/file2.txt");
        System.out.println(Files.exists(path));
        Files.createFile(path);
        System.out.println(Files.isRegularFile(path));
        System.out.println(path.toAbsolutePath());
        System.out.println(Files.size(path));
        System.out.println(Files.getLastModifiedTime(path));
        BasicFileAttributes basicFileAttributes = Files.readAttributes(file.toPath(), BasicFileAttributes.class);



    }
}
