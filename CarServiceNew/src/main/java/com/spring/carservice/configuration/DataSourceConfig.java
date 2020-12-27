package com.spring.carservice.configuration;

import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.transaction.TransactionManager;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource(Environment environment) {

        DriverManagerDataSource dataSource = new SingleConnectionDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("datasource.driver"));
        dataSource.setUrl(environment.getRequiredProperty("datasource.url"));
        dataSource.setUsername(environment.getRequiredProperty("datasource.username"));
        dataSource.setPassword(environment.getRequiredProperty("datasource.password"));
        ((SingleConnectionDataSource) dataSource).setSuppressClose(true);

        return dataSource;
    }

    @Bean
    @DependsOn("dataSource")
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
        return jdbcTemplate;
    }

    @Bean
    @Scope(value = "prototype")
    @DependsOn("dataSource")
    public SimpleJdbcInsert simpleJdbcInsert(DataSource dataSource) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
        return simpleJdbcInsert;
    }
    @Bean
    @Primary
    public TransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
