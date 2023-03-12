package com.cm.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CmModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmModuleApplication.class, args);
	}

}
