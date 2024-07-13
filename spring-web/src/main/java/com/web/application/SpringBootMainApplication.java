package com.web.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.web.*")
@EnableJpaRepositories("com.web.*")
@ComponentScan(basePackages = "com.web.*")

public class SpringBootMainApplication extends SpringBootServletInitializer  {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootMainApplication.class, args);
    }
}
