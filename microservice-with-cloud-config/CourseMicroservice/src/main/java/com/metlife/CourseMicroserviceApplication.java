package com.metlife;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CourseMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseMicroserviceApplication.class, args);
	}

}
