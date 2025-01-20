package com.cog.config;


import com.cog.utils.PropertiesUtils;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder, DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.cog.dom") // Replace with your entity package
                .persistenceUnit("default")
                .properties(PropertiesUtils.convertPropertiesToMapLatest(hibernateProperties()))  // Setting Hibernate properties including dialect
                .build();
    }

    @Bean
    public EntityManagerFactoryBuilder entityManagerFactoryBuilder() {
        return new EntityManagerFactoryBuilder(new HibernateJpaVendorAdapter(), new HashMap<>(), null);
    }
//
//    @Bean
//    @Primary
//    public DataSource dataSource() {
//        return DataSourceBuilder.create()
//                .url("jdbc:h2:file:C:/Users/91998/test/testdb;DB_CLOSE_ON_EXIT=FALSE")
//                .username("sa")
//                .password("password")
//                .driverClassName("org.h2.Driver")
//                .build();
//    }
//
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

    private Properties hibernateProperties() {
        Properties properties = new Properties();


        // Specify the Hibernate Dialect (adjust this for your DB)
        properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");  // Set the correct dialect

        // Specify other Hibernate properties if needed
        properties.put("hibernate.hbm2ddl.auto", "create");  // Auto-create/update DB schema
        properties.put("hibernate.show_sql", "true");  // Show SQL queries in console
        properties.put("hibernate.format_sql", "true");  // Format SQL for readability
        properties.put("hibernate.use_sql_comments", "true"); // Add comments in the SQL


        return properties;
    }


}
