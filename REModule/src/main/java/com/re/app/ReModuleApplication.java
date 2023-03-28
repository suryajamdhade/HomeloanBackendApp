package com.re.app;

import org.modelmapper.ModelMapper;	
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import org.springframework.context.annotation.Bean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class ReModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReModuleApplication.class, args);
	}
	
	@Bean
	public ModelMapper mapper() {
		return new ModelMapper();
	}

}
