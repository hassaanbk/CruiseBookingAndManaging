package com.micro.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class CustomerMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroServiceApplication.class, args);
		System.out.println("Customer booking servive running");
	}

}
