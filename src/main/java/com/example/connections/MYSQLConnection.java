package com.example.connections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MYSQLConnection {

    private static final Logger LOGGER =  LoggerFactory.getLogger(MYSQLConnection.class);

    public void connect(String url, String username, String password) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            LOGGER.info("Trying to connect to: {}",  url);
            LOGGER.info("Connected successfully to database: {} ", url);
            connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException("Connection to mysql database failed! ", e);
        }
    }

}
