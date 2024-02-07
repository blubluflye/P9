package com.p9.microservicenote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceNoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceNoteApplication.class, args);
	}

}
