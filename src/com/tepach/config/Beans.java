package com.tepach.config;

import com.tepach.bean.*;
import javax.sql.DataSource;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

    @Configuration
    @ComponentScan("com.tepach")
    @Lazy(value = true)
public class Beans {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Persona persona() {
        return new Persona();
    }

    @Bean
    public Pais pais() {
        return new Pais();
    }

    @Bean
    public Ciudad ciudad() {
        return new Ciudad();
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://192.168.1.166/springdb");
        dataSource.setUsername("anthonytepach");
        dataSource.setPassword("Tbryan.1996");
        return dataSource;
    }
}
