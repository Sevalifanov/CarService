package com.spring.carservice.configuration;

import org.springframework.context.annotation.*;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
@ComponentScan(basePackages = "com.spring.carservice")
public class ApplicationConfig {
}




