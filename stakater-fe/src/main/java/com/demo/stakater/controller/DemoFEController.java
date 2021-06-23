package com.demo.stakater.controller;

import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.demo.stakater.model.DateTimeFormatEnum;

@RestController
@RequestMapping("/api/v1")
public class DemoFEController {

	@Value("${backend.k8s.service.dns.name}")
    private String backendServiceDNSName;
	
	@Value("${backend.k8s.service.endpoint}")
	private String backendServiceEndPoint;
	
    @GetMapping(value = "/print")
	public String helloWorld() throws UnknownHostException {

    	System.out.println("I am in Front End Micro service");
		RestTemplate restTemplate = new RestTemplate();
		StringBuilder resourceUrl = new StringBuilder();
		resourceUrl.append(backendServiceDNSName).append(backendServiceEndPoint);
		String dateTime = formatDateTime(LocalDateTime.now(), DateTimeFormatEnum.YYYY_MM_DD_HH_MM_SS);
		System.out.println("Going to lookup Backend K8s service on Pod " + resourceUrl.toString());
		ResponseEntity<String> response = restTemplate.getForEntity(resourceUrl.toString(), String.class);
		return dateTime + " " +response.getBody();
	}
    
	private String formatDateTime(LocalDateTime dateTime, DateTimeFormatEnum dateTimeFormatEnum) {
		if (dateTime == null || dateTimeFormatEnum == null)
			return "";

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateTimeFormatEnum.getFormat());
		return dateTime.format(formatter);
	}
}
