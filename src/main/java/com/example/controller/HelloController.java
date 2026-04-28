package com.example.controller;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${HOSTNAME:unknown}")
	private String hostname;

	@GetMapping("/hello")
	public String hello(HttpServletRequest request) {
		return "From Spring Boot with Instance: " + hostname
				+ ", date: " + LocalDateTime.now()
				+ ", port: " + request.getServerPort();
	}
}
