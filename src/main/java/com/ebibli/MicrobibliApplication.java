package com.ebibli;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicrobibliApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(MicrobibliApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MicrobibliApplication.class, args);
        LOGGER.info("L'application a démarré...");
    }
}
