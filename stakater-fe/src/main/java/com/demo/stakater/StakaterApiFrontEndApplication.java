package com.demo.stakater;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StakaterApiFrontEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(StakaterApiFrontEndApplication.class, args);
	}
}