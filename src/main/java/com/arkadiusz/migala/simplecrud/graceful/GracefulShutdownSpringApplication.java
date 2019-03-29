package com.arkadiusz.migala.simplecrud.graceful;

import org.springframework.boot.SpringApplication;

public class GracefulShutdownSpringApplication {
    public static void run(Class<?> appClazz, String... args) {
        final var app = new SpringApplication(appClazz);
        app.setRegisterShutdownHook(false);

        final var appCtx = app.run(args);
        Runtime
            .getRuntime()
            .addShutdownHook(new Thread(new GracefulShutdownHook(appCtx)));
    }
}
