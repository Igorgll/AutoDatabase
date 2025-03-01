package com.example.annotations;

import com.example.enums.DatabaseType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface AutoDatabase {

    DatabaseType type();
    String url();
    String username();
    String password();

}
