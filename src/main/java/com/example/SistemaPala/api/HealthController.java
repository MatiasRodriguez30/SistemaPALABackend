package com.example.SistemaPala.api;

import com.example.SistemaPala.api.dto.ApiResponse;
import com.example.SistemaPala.api.dto.SystemInfoResponse;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/sistema")
public class HealthController {

	private final Environment environment;
	private final String applicationName;

	public HealthController(Environment environment, @Value("${spring.application.name}") String applicationName) {
		this.environment = environment;
		this.applicationName = applicationName;
	}

	@GetMapping("/salud")
	public ApiResponse<SystemInfoResponse> health() {
		List<String> activeProfiles = Arrays.stream(environment.getActiveProfiles()).toList();
		SystemInfoResponse payload = new SystemInfoResponse(applicationName, "UP", activeProfiles, Instant.now());
		return ApiResponse.success("Sistema operativo", payload);
	}
}
