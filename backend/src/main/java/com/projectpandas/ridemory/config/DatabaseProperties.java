package com.projectpandas.ridemory.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/secrets.properties")
public class DatabaseProperties {

    @Value("${spring.data.mongodb.database}")
    private String dbName;

}
