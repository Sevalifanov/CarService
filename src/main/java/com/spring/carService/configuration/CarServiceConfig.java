package com.spring.carService.configuration;

import com.spring.carService.service.GarageService;
import com.spring.carService.service.GarageServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.spring.carService")
public class CarServiceConfig {
    @Bean
    GarageService garageService(){return new GarageServiceImpl();
    }
}
