package com.example.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    Socket clientSocket;
    PrintWriter out;
    BufferedReader in;

    public void start(String ip, int port){
        System.out.println("Iniciando client");

        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String send(String message){
        System.out.println("Client envía mensaje: " + message);


        try {
            out.println(message);
            String response = in.readLine();
            System.out.println("Client recibe respuesta: " + response);
            return response;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ERROR: No hubo mensaje";
    }

    public void stop(){
        try{
            in.close();
            out.close();
            clientSocket.close();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
