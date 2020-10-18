package com.spring.carService;

import com.spring.carService.configuration.CarServiceConfig;
import com.spring.carService.service.GarageService;
import com.spring.carService.service.GarageServiceImpl;
import com.spring.carService.model.Car;
import com.spring.carService.model.Mechanic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(CarServiceConfig.class);

        GarageService garageService =(GarageServiceImpl)context.getBean("garageService");
        Mechanic mechanic = new Mechanic(1L,"Ivan","Ivanov");
        Car car = new Car(1L, "Ford","Focus", mechanic);
        garageService.addNewCar(car,mechanic,10000L);

    }
}
