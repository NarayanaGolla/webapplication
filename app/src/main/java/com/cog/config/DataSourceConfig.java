//package com.cog.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.jdbc.DataSourceBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//import javax.sql.DataSource;
//
//
//@Configuration
//public class DataSourceConfig {
//
//    @Value("${datasource.type}")
//    private String datasourceType;
//
//    @Value("${spring.datasource.url}")
//    private String dburl;
//
//    @Value("${spring.datasource.driver-class-name}")
//    private String driverClassName;
//
//    @Value("${spring.datasource.username}")
//    private String username;
//
//    @Value("${spring.datasource.password}")
//    private String password;
//
//
//
//    @Bean
//    @Profile("dev")
//    public DataSource devDataSource() {
//        return DataSourceBuilder.create()
//                .url(dburl)
//                .driverClassName(driverClassName)
//                .username(username)
//                .password(password)
//
//                .build();
//    }
//
//    @Bean
//    @Profile("prod")
//    public DataSource prodDataSource() {
//        return DataSourceBuilder.create()
//                .url("jdbc:mysql://prod-db-server:3306/prod_db")
//                .username("prod_user")
//                .password("prod_pass")
//                .build();
//    }
//
//
//}
//
