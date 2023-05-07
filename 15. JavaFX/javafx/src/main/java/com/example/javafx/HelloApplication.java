package com.example.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Opción 1: crear la interfaz desde Java:
//        Label label = new Label("Enter your name:");
//        TextField textField = new TextField();
//
//        Button sayHelloBtn = new Button("Say Hello");
//        Button exitBtn = new Button("Exit");
//
//        Label message = new Label();
//        message.setStyle("-fx-text-fill: #ff002f;");
//
//        sayHelloBtn.setOnAction(event -> {
//            String name = textField.getText();
//
//            if (name.trim().length() > 0)
//                message.setText("Hello " + name);
//            else
//                message.setText("Hello !!");
//        });
//
//        exitBtn.setOnAction(e -> Platform.exit());
//
//        VBox root = new VBox();
//        root.setSpacing(5);
//        root.getChildren().addAll(label, textField, message, sayHelloBtn, exitBtn);
//
//        Scene scene = new Scene(root, 350, 150);
//        stage.setScene(scene);
//        stage.setTitle("My Awesome APP");
//        stage.show();


        // Opción 2: utilizando plantillas FXML (Recomendable)
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {
        System.out.println("init() method: " + Thread.currentThread().getName());
    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop() method: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        launch();
    }
}