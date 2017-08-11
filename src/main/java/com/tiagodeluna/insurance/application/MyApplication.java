package com.tiagodeluna.insurance.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.tiagodeluna.insurance.controller",
		"com.tiagodeluna.insurance.service",
		"com.tiagodeluna.insurance.persistence"})
public class MyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(MyApplication.class, args);
		System.out.println("Running...");
	}
}
