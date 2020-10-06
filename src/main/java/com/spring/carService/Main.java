package com.spring.carService;

import com.spring.carService.Service.GarageService;
import com.spring.carService.Service.GarageServiceImpl;
import com.spring.carService.model.Car;
import com.spring.carService.model.Mechanic;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context= new ClassPathXmlApplicationContext("spring-context.xml");

        GarageService garageService =(GarageService)context.getBean("garageService");
        Car car = new Car();
        Mechanic mechanic = new Mechanic();
        garageService.addNewCar(car,mechanic);

    }
}
