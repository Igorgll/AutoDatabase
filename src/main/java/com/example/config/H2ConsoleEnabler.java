package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;

import java.util.Properties;

public class H2ConsoleEnabler implements EnvironmentPostProcessor {

    private static final Logger LOGGER = LoggerFactory.getLogger(H2ConsoleEnabler.class);

    // adicionar condição para setar a property somente se o banco for H2
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

            MutablePropertySources propertySources = environment.getPropertySources();

            Properties properties = new Properties();
            properties.setProperty("spring.h2.console.enabled", "true");

            propertySources.addFirst(new PropertiesPropertySource("customH2Properties", properties));
    }
}
