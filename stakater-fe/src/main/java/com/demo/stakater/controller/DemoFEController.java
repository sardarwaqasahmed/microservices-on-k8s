package com.demo.stakater.controller;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.stakater.model.DateTimeFormatEnum;

@RestController
@RequestMapping("/api/v1")
public class DemoFEController {

    
    @GetMapping(value = "/print")
	public String helloWorld() throws UnknownHostException {

		RestTemplate restTemplate = new RestTemplate();
		String resourceUrl = "http://stakater-be-api:8081/stakater-be/api/v1/hello";
		String dateTime = formatDateTime(LocalDateTime.now(), DateTimeFormatEnum.YYYY_MM_DD_HH_MM_SS);
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl, String.class);
		return dateTime + response.getBody();
	}
    
	private String formatDateTime(LocalDateTime dateTime, DateTimeFormatEnum dateTimeFormatEnum) {
		if (dateTime == null || dateTimeFormatEnum == null)
			return "";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatEnum.getFormat());
		return dateTime.format(formatter);
	}
}
