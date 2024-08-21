package com.web.application.config;
import com.web.application.interceptor.CustomInterceptor;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

//import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;



@Configuration
public class AppConfig {

    @Bean
    public CustomInterceptor customInterceptor() {
        return new CustomInterceptor();
    }

}

