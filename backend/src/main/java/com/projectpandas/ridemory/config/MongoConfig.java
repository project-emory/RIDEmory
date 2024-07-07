package com.projectpandas.ridemory.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.lang.NonNull;

@Configuration
@PropertySource("classpath:/secrets.properties")
public class MongoConfig extends AbstractMongoClientConfiguration {
    @Value("${spring.data.mongodb.database}")
    private String dbName;

    @NonNull
    @Override
    protected String getDatabaseName() {
        return dbName == null ? "ridemory" : dbName;
    }

    /**
     * Add custom converters for fields here. See
     * https://claude.ai/chat/20ddd7a4-7414-4611-921a-a5a38ae6a278
     */
    @NonNull
    @Bean
    public MongoCustomConversions customConversions() {
        List<Converter<?, ?>> converters = new ArrayList<>();
        return new MongoCustomConversions(converters);
    }
}
