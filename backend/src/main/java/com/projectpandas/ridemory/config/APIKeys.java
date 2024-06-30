package com.projectpandas.ridemory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/secrets.properties")
public class APIKeys {
    @Value("${google.api.key}")
    public static String googleAPIKey;
}
