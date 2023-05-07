package com.example.jakartawebsocket;

import jakarta.json.Json;
import jakarta.json.bind.Jsonb;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import jakarta.json.bind.JsonbBuilder;

import java.io.IOException;
import java.util.stream.Collectors;

/*
Para crear encoders crear una clase separada que implemente:
implements Encoder.Text<Message>

Para crear decoders:
implements Decoder.Text<Message>
 */
@ServerEndpoint(value = "/webchat")
//@ServerEndpoint(value = "/webchat", encoders = {}, decoders = {})
public class WebChat {

    @OnMessage
    public void onMessage(Session session, String text){

        try(Jsonb jsonb = JsonbBuilder.create()){

            Message message = jsonb.fromJson(text, Message.class);
            System.out.println(message);

            if (message.getType().equals("join")){
                session.getUserProperties().put("name", message.getUserName());
                session.getUserProperties().put("active", true); // el usuario se acaba de unir

                Message info = new Message(message.getUserName(), "info", message.getUserName() + " has joined the chat");
                Message updateUserList = new Message(message.getUserName(), "users", getUserNames(session));

                sendAll(session, info);
                sendAll(session, updateUserList);

            } else if(message.getType().equals("chat")){
                sendAll(session, message);
            }


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void sendAll(Session session, Message message) {
        String json = Json.createObjectBuilder()
                .add("userName", message.getUserName())
                .add("type", message.getType())
                .add("body", message.getBody()).build().toString();

        session.getOpenSessions().stream()
                .filter(Session::isOpen)
                .forEach(s -> {
                    try {
                        s.getBasicRemote().sendText(json);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });


    }

    private String getUserNames(Session session) {
        return session.getOpenSessions().stream()
                .filter(Session::isOpen)
                .filter(s -> s.getUserProperties().get("active") != null && (boolean) s.getUserProperties().get("active"))
                .filter(s -> s.getUserProperties().get("name") != null)
                .map(s -> (String) s.getUserProperties().get("name"))
                .collect(Collectors.joining(", "));
    }

    @OnError
    public void onError(Session session, Throwable e){
        e.printStackTrace();
    }

    @OnClose
    public void onClose(Session session){
        session.getUserProperties().put("active", false);
        if (session.getUserProperties().containsKey("name")){
            String name = session.getUserProperties().get("name").toString();

            Message info = new Message(name, "info", name + " has left the chat");
            Message updateUserList = new Message(name, "users", getUserNames(session));

            sendAll(session, info);
            sendAll(session, updateUserList);
        }
    }

}
