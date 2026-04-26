package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class HealthController {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@GetMapping("/health")
	public Map<String, String> health() {
		try {
			jdbcTemplate.queryForObject("SELECT 1", Integer.class);
			return Map.of("status", "UP", "database", "reachable");
		} catch (Exception e) {
			return Map.of("status", "DOWN",
					"database", "unreachable",
					"error", e.getMessage());
		}
	}
}
