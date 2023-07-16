package com.novi.bootcamp.novifsdbackendeindopdrachtsoundwwiseprototype;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
@ServletComponentScan
@MultipartConfig
public class NoviFsdBackendEindopdrachtSoundwwisePrototypeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoviFsdBackendEindopdrachtSoundwwisePrototypeApplication.class, args);
	}

}
