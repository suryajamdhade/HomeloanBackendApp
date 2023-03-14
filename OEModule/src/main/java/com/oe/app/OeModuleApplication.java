package com.oe.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OeModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(OeModuleApplication.class, args);
	}

}
