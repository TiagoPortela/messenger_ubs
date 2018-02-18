package com.ubs.tiagoportela.messenger_ubs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MessengerUbsApplication {

	private static final Logger logger = LoggerFactory.getLogger(MessengerUbsApplication.class);

	public static void main(String[] args) {
		logger.info("Starting MessengerUbs service");
		SpringApplication.run(MessengerUbsApplication.class, args);
	}
}
