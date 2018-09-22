package com.arkadiusz.migala.simplecrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class SimpleCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleCrudApplication.class, args);
    }

}
