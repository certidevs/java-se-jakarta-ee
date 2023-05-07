package com.example.read;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadMain {

    public static final String FILE = "src/main/resources/file4.txt";

    public static void main(String[] args) throws IOException {

        // antes de leer un archivo, comprobar si es posible
        Path path = Path.of(FILE); // crearlo manualmente
//        System.out.println(Files.exists(path));
//        System.out.println(Files.isReadable(path));

        // leer un archivo Java NIO
        Files.readAllLines(path).forEach(System.out::println);
        Files.lines(path)
                .filter(line -> line.contains("mundo"))
                .map(String::length)
                .forEach(System.out::println);

        // leer un archivo Java IO
        BufferedReader bufferedReader = null;
        List<String> lines = new ArrayList<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(FILE));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (bufferedReader != null)
                bufferedReader.close();
        }
        System.out.println(lines);

        lines = new ArrayList<>();
        // try with resources
        try(
            FileReader reader = new FileReader(FILE);
            BufferedReader bufferedReader2 = new BufferedReader(reader);
            ){
            String line;
            while ((line = bufferedReader2.readLine()) != null) {
                lines.add(line);
            }
        }catch (IOException e) {e.printStackTrace();}
        System.out.println(lines);
    }
}
