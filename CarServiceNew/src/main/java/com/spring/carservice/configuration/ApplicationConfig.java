package com.spring.carservice.configuration;

import org.springframework.context.annotation.*;

@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "com.spring.carservice")
public class ApplicationConfig {
}




