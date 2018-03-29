package com.klasnic.pos.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages="com.klasnic.pos.model.catalogs")
@EnableJpaRepositories("com.klasnic.pos.model.repositories")
@ComponentScan(basePackages="com.klasnic.pos.model.services.impl")
@ComponentScan(basePackages="com.klasnic.pos.model.controllers")
@ComponentScan(basePackages="com.klasnic.pos.process")
public class PosServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosServerApplication.class, args);
	}
	
}
