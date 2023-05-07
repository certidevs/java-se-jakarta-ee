package com.example.apiextension;

import com.example.demo.extensions.ConnectionDB;
import com.example.demo.extensions.DirectionDDL;
import org.junit.jupiter.api.extension.*;

import java.sql.Connection;

public class DatabaseExtension implements BeforeAllCallback, BeforeEachCallback, AfterAllCallback {

    private Connection connection;


    @Override
    public void beforeAll(ExtensionContext context) throws Exception {
        connection = ConnectionDB.openConnection();
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        DirectionDDL.dropTable(connection);
        DirectionDDL.createTable(connection);
    }

    @Override
    public void afterAll(ExtensionContext context) throws Exception {
        ConnectionDB.closeConnection();
    }




}
