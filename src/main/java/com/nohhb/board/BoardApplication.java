package com.nohhb.board;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BoardApplication implements CommandLineRunner {
    @Autowired
    EntityManagerFactory emf;
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(BoardApplication.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {

    }
}
