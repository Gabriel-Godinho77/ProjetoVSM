package com.fuentes.vsm_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.fuentes.vsm_backend.repository")
public class VsmBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(VsmBackendApplication.class, args);
	}

}
