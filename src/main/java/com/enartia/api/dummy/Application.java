package com.enartia.api.dummy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EntityScan(basePackages = { "com.enartia.api.dummy.persistence.${app.brand}" })
@EnableJpaRepositories(basePackages = { "com.enartia.api.dummy.persistence.${app.brand}" })
//TODO: ExceptionHandler & Custom Error codes
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}

}
