package com.example.SistemaPala.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI sistemaPalaOpenAPI() {
		return new OpenAPI().info(new Info()
				.title("Sistema PALA")
				.description("API general del sistema PALA")
				.version("v1"));
	}
}
