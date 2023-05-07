package com.example.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public void start(int port) {
        System.out.println("Iniciando server");

        try {
            serverSocket = new ServerSocket(port);
            clientSocket = serverSocket.accept();
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null){
                System.out.println("Server recibe mensaje: "+ inputLine);
                if ("exit".equals(inputLine)){
                    System.out.println("Server cerrando");
                    out.println("good bye");
                    break;
                }
                System.out.println("Server envía mensaje");
                out.println(inputLine);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Fin server");

    }

    public void stop(){

        try{
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
