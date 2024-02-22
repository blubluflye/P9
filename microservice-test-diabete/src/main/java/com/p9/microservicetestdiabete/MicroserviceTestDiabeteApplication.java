package com.p9.microservicetestdiabete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceTestDiabeteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceTestDiabeteApplication.class, args);
	}

}
