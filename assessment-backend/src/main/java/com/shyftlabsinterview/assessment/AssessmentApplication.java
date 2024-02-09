package com.shyftlabsinterview.assessment;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.TimeZone;

@SpringBootApplication
public class AssessmentApplication {

	@Value("${frontend.domain}")
	private String frontendDomain;

	public static void main(String[] args) {
		SpringApplication.run(AssessmentApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/course/**").allowedOrigins(frontendDomain).allowedMethods("GET", "POST", "DELETE");
				registry.addMapping("/result/**").allowedOrigins(frontendDomain).allowedMethods("GET", "POST", "DELETE");
				registry.addMapping("/student/**").allowedOrigins(frontendDomain).allowedMethods("GET", "POST", "DELETE");
			}
		};
	}

	// solve issue regarding timezone issue for date saved to database using hibernate
	@PostConstruct
	void postConstruct() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
