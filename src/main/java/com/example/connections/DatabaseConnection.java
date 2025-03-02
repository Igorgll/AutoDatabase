package com.example.connections;

import com.example.enums.DatabaseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final Logger LOGGER =  LoggerFactory.getLogger(DatabaseConnection.class);

    public void connect(DatabaseType databaseType, String url, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            LOGGER.info("Database type: {}", databaseType);
            LOGGER.info("Trying to connect to: {}", url);
            LOGGER.info("Connected successfully to database: {} ", url);
            connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("Connection to " + databaseType + " database failed! ", e);
        }
    }
}
