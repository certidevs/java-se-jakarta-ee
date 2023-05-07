package com.example.demo.extensions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DirectionDDL {

    public static void createTable(Connection connection) {

        String sql = """
                create table directions
                (
                    id int auto_increment,
                    street varchar(200) not null,
                    postal_code varchar(5) null,
                    province varchar(200) null,
                    country varchar(100) null,
                    constraint directions_pk
                        primary key (id)
                );
                """;
        executeStatement(connection, sql);
    }

    public static void dropTable(Connection connection) {

        String sql = "DROP TABLE IF EXISTS directions;";
        executeStatement(connection, sql);
    }

    private static void executeStatement(Connection connection, String sql) {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
