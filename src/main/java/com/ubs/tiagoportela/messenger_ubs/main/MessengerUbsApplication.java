package com.ubs.tiagoportela.messenger_ubs.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.ubs")
@EnableJpaRepositories("com.ubs.tiagoportela.messenger_ubs.repositories")
@EntityScan("com.ubs.tiagoportela.messenger_ubs.models")
public class MessengerUbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MessengerUbsApplication.class, args);
	}
}
