package com.cog.mainapplication;

import com.cog.config.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

//@SpringBootApplication(exclude = {MyConfig.class})
@SpringBootApplication
@ComponentScan(basePackages = "com.cog",
		excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = DataSourceConfig.class))
public class CogApplication {

	public static void main(String[] args) {
		SpringApplication.run(CogApplication.class, args);
	}

}
