package com.st;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HerokuSalesForceApplication {

	private final static Logger logger = LoggerFactory.getLogger(HerokuSalesForceApplication.class);

	public static void main(String[] args) {
		logger.debug("Starting SpringBootHerokuApplication...");
		SpringApplication.run(HerokuSalesForceApplication.class, args);
		logger.debug("Configuration finished for SpringBootHerokuApplication ");

	}
}
