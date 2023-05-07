package com.example.demo.extensions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    public static Connection openConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/javajdbc";
            String user = "root";
            String password = "admin";
            connection = DriverManager.getConnection(url, user, password);
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void closeConnection() {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
