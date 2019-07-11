package com.enartia.api.dummy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
        	.csrf().disable()
        	.authorizeRequests()
        	.anyRequest().authenticated()
        .and()
        	.httpBasic()
    	.and()
        	.sessionManagement().disable();
    }
	
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager(ApplicationConfig applicationConfig) {
		final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
		log.info("Importing {} clients:", applicationConfig.getUsers().size());

		applicationConfig.getUsers().forEach(client -> {
			manager.createUser(User.withDefaultPasswordEncoder()
					.username(client.getUsername())
					.password(client.getPassword())
					.roles(client.getRoles())
					.build());
			log.info("Imported client {}", client.toString());
		});

		return manager;
	}
}
