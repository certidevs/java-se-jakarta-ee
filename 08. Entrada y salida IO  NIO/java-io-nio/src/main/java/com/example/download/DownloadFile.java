package com.example.download;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class DownloadFile {

    public static void main(String[] args) throws IOException {


        String url = "https://raw.githubusercontent.com/mwaskom/seaborn-data/master/tips.csv";

        String[] urlParts = url.split("/");
        String fileName = urlParts[urlParts.length - 1];

        InputStream input = new URL(url).openStream();

        Path path = Paths.get("src/main/resources/" + fileName);
//        Files.copy(input, path); // FileAlreadyExistsException
        Files.copy(input, path, StandardCopyOption.REPLACE_EXISTING);

    }
}
