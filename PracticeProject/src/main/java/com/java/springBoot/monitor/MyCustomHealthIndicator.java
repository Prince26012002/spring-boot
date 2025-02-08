package com.java.springBoot.monitor;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

import com.java.springBoot.annotation.MyCustomComponent;

@MyCustomComponent
public class MyCustomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		boolean serviceUp = checkExternalService();
		if (serviceUp) {
			return Health.up().withDetail("External Service", "Avaliable").build();
		} else {
			return Health.down().withDetail("External Service", "Not Avaliable").build();
		}
	}

	private boolean checkExternalService() {
		// Logic to check external service health
		return true;
	}

}
