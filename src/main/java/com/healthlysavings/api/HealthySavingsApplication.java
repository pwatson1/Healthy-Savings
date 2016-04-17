package com.healthlysavings.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HealthySavingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthySavingsApplication.class, args);
	}
}
