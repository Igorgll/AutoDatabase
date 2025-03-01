package com.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "auto.database")
public class AutoDatabaseProperties {

    private boolean autoDatabaseEnabled;

    public boolean isAutoDatabaseEnabled() {
        return autoDatabaseEnabled;
    }

    public void setAutoDatabaseEnabled(boolean autoDatabaseEnabled) {
        this.autoDatabaseEnabled = autoDatabaseEnabled;
    }
}
