package com.cog.mainapplication;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = "com.cog.*")
@EntityScan(basePackages = "com.cog.*")
@EnableJpaRepositories(basePackages = "com.cog.*")
public class CogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CogApplication.class, args);
	}
}
