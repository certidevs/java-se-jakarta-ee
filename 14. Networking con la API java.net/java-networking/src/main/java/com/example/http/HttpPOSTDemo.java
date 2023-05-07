package com.example.http;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpPOSTDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        String url = "https://dummy.restapiexample.com/api/v1/create";

        String employee = """
                {
                    "name" : "java employee",
                    "salary" : "90000",
                    "age" : "35"
                }
                """;


        var request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(employee))
                .build();

        var response = HttpClient.newHttpClient().send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        System.out.println(response.statusCode());
        System.out.println(response.body());
        System.out.println(response.headers());

    }
}
