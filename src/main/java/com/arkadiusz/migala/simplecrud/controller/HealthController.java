package com.arkadiusz.migala.simplecrud.controller;

import com.arkadiusz.migala.simplecrud.state.HealthStateSetter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/health")
@RequiredArgsConstructor
@Log4j2
public class HealthController {
    private final HealthStateSetter healthState;

    @GetMapping("up")
    public void makeUp(HttpServletResponse response) {
        log.info("Setting application state to UP");
        healthState.makeHealth();
        redirectToHealthCheckEndpoint(response);

    }

    @GetMapping("down")
    public void makeDown(HttpServletResponse response) {
        log.warn("Setting application stat to DOWN");
        healthState.makeUnhealth();
        redirectToHealthCheckEndpoint(response);
    }

    @SneakyThrows
    private void redirectToHealthCheckEndpoint(HttpServletResponse response) {
        response.sendRedirect("/actuator/health");
    }
}
