package com.example.config;

import com.example.annotations.AutoDatabase;
import com.example.connections.MYSQLConnection;
import com.example.enums.DatabaseType;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "auto.database.enabled", havingValue = "true", matchIfMissing = false)
public class DatabaseInitializer {

    public void init(Class<?> clazz) {
        AutoDatabase dbConfig = clazz.getAnnotation(AutoDatabase.class);
        DatabaseType type = dbConfig.type();
        String url = dbConfig.url();
        String username = dbConfig.username();
        String password = dbConfig.password();

        if (String.valueOf(type).equals("MYSQL")) {
            new MYSQLConnection().connect(url, username, password);
        }

    }

}
