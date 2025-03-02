package com.example.config;

import com.example.annotations.AutoDatabase;
import com.example.connections.DatabaseConnection;
import com.example.enums.DatabaseType;
import org.springframework.stereotype.Component;

@Component
public class DatabaseInitializer {

    public void init(Class<?> clazz) {
        AutoDatabase dbConfig = clazz.getAnnotation(AutoDatabase.class);
        DatabaseType databaseType = dbConfig.type();
        String url = dbConfig.url();
        String username = dbConfig.username();
        String password = dbConfig.password();
        new DatabaseConnection().connect(databaseType, url, username, password);
    }

}
