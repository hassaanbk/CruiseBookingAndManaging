package com.micro.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AdminMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminMicroServiceApplication.class, args);
		System.out.println("Admin Micro Service Running");
	}

}
