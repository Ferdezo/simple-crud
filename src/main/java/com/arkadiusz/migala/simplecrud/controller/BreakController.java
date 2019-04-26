package com.arkadiusz.migala.simplecrud.controller;

import com.arkadiusz.migala.simplecrud.state.Shutdown;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/break")
@RequiredArgsConstructor
@Log4j2
public class BreakController {
    private final Shutdown shutdownManager;

    @GetMapping
    public void breakApplication() {
        log.warn("Setting application to unhealth state");
        shutdownManager.initiateShutdown(3);
        throw new IllegalStateException("Application should be shutdown");
    }

}
