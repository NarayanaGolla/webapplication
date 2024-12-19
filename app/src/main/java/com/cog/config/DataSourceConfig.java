package com.cog.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @Profile("dev")
    public DataSource devDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/dev_db")
                .username("dev_user")
                .password("dev_pass")
                .build();
    }

    @Bean
    @Profile("prod")
    public DataSource prodDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://prod-db-server:3306/prod_db")
                .username("prod_user")
                .password("prod_pass")
                .build();
    }
}

