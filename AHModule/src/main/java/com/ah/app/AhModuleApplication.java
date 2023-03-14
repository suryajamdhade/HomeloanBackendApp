package com.ah.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AhModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AhModuleApplication.class, args);
	}

}
