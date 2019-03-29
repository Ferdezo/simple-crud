package com.arkadiusz.migala.simplecrud;

import com.arkadiusz.migala.simplecrud.graceful.GracefulShutdownSpringApplication;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@Log4j2
public class SimpleCrudApplication {

    public static void main(String[] args) {
        if (isGraceful(args)) {
            log.info("Starting Spring Boot Application - graceful");
            GracefulShutdownSpringApplication.run(SimpleCrudApplication.class, args);
        } else {
            log.info("Starting Spring Boot Application - normal");
            SpringApplication.run(SimpleCrudApplication.class, args);
        }
    }

    private static boolean isGraceful(String[] args) {
        return args != null && args.length > 0 && args[0].equals("graceful");
    }

}
