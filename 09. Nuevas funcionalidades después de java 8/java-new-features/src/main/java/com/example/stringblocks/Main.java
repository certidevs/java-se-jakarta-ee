package com.example.stringblocks;

public class Main {


    public static void main(String[] args) {

        String description = "Hola mundo"
                + "que tal"
                + "hasta luego";

        String description2 = """
                Hola mundo
                que tal
                hasta luego
                """;

        String html = """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Title</title>
                </head>
                <body>
                <h1>Hola mundo</h1>
                </body>
                </html>
                """;

        String html2 = String.format("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>%s</title>
                </head>
                <body>
                <h1>Hola mundo</h1>
                </body>
                </html>
                """, "Awesome App");
        System.out.println(html2);


    }
}
