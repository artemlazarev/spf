package ru.spf.relation.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.yml")
@Configuration
public class H2Config {

    private static final Logger logger = LoggerFactory.getLogger(H2Config.class);

    @Value("${spring.h2.serverPort}")
    private String serverPort;
}
