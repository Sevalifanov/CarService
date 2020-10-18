package com.spring.carService.service;

import com.spring.carService.model.Car;
import com.spring.carService.model.Mechanic;

public interface GarageService {
    boolean addNewCar(Car car, Mechanic mechanic);
}
