package com.enartia.api.dummy;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "app")
@Validated
@Getter
@Setter
@NoArgsConstructor
public class ApplicationConfig {
	
	@NotBlank
	private String brand;
	
	@NotEmpty
	private final List<ApplicationUser> users = new ArrayList<>();
	
	@Getter
	@Setter
	@NoArgsConstructor
	public static class ApplicationUser {
	    private String username;
	    private String password;
	    private String[] roles;
	}
	
}
