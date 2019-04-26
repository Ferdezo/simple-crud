package com.arkadiusz.migala.simplecrud.graceful;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.util.StringUtils;

import java.util.Map;

@RequiredArgsConstructor
@Log4j2
public class GracefulShutdownHook implements Runnable {
    protected static final String GRACEFUL_SHUTDOWN_WAIT_SECONDS = "estaGracefulShutdownWaitSeconds";
    private static final String DEFAULT_GRACEFUL_SHUTDOWN_WAIT_SECONDS = "5";

    private final ConfigurableApplicationContext applicationContext;

    @Override
    public void run() {
        setReadynessToFalse();
        delayShutdownSpringContext();
        shutdownSpringContext();
    }

    private void shutdownSpringContext() {
        log.info("Spring Application context starting to shutdown");
        applicationContext.close();
        log.info("Spring Application context is shutdown");
    }

    private void setReadynessToFalse() {
        log.info("Setting readiness for application to false, so the application doesn't receive new connections from Openshift");
        final Map<String, ProbeController> probeControllers = applicationContext.getBeansOfType(ProbeController.class);
        if (probeControllers.size() < 1) {
            log.error("Could not find a ProbeController Bean. Your ProbeController needs to implement the Interface: " + ProbeController.class.getName());
        }
        if (probeControllers.size() > 1) {
            log.warn("You have more than one ProbeController for Readiness-Check registered. " +
                "Most probably one as Rest service and one in automatically configured as Actuator health check.");
        }
        for (ProbeController probeController : probeControllers.values()) {
            probeController.setReady(false);
        }
    }

    private void delayShutdownSpringContext() {
        try {
            int shutdownWaitSeconds = getShutdownWaitSeconds();
            log.info("Gonna wait for " + shutdownWaitSeconds + " seconds before shutdown SpringContext!");
            Thread.sleep(shutdownWaitSeconds * 1000);
        } catch (InterruptedException e) {
            log.error("Error while gracefulshutdown Thread.sleep", e);
        }
    }

    /**
     * Tries to get the value from the Systemproperty estaGracefulShutdownWaitSeconds,
     * otherwise it tries to read it from the application.yml, if there also not found 20 is returned
     *
     * @return The configured seconds, default 20
     */
    private int getShutdownWaitSeconds() {
        String waitSeconds = System.getProperty(GRACEFUL_SHUTDOWN_WAIT_SECONDS);
        if (StringUtils.isEmpty(waitSeconds)) {
            waitSeconds = applicationContext.getEnvironment().getProperty(GRACEFUL_SHUTDOWN_WAIT_SECONDS, DEFAULT_GRACEFUL_SHUTDOWN_WAIT_SECONDS);
        }
        return Integer.parseInt(waitSeconds);
    }
}
