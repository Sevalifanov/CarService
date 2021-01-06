package com.spring.carservice.configuration;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAsync
@ComponentScan(basePackages = "com.spring.carservice")
@EnableTransactionManagement
public class ApplicationConfig {
}




