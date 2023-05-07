package com.example.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        // obtener puerto libre
        ServerSocket server = new ServerSocket(0);
        int port = server.getLocalPort();
        server.close();

        // crear server socket
        Executors.newSingleThreadExecutor().submit(() -> new Server().start(port));
        Thread.sleep(1000L);

        // crear client
        Client client = new Client();
        client.start("127.0.0.1", port);

        client.send("hello");
        client.send("world");
        client.send("!");
        client.send("exit");

        client.stop();


    }
}
