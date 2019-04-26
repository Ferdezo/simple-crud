package com.arkadiusz.migala.simplecrud.state.actuator;

import com.arkadiusz.migala.simplecrud.state.HealthStateSetter;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class ConfigurableHealthIndicator implements HealthIndicator, HealthStateSetter {
    private AtomicBoolean isHealthy = new AtomicBoolean(true);

    @Override
    public Health health() {
        return isHealthy.get() ?
            Health.up().build() :
            Health.down().build();
    }

    @Override
    public boolean makeHealth() {
        return isHealthy.getAndSet(true);
    }

    @Override
    public boolean makeUnhealth() {
        return isHealthy.getAndSet(false);
    }

}
