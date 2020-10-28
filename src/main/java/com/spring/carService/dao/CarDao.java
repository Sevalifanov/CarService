package com.spring.carService.dao;

import com.spring.carService.model.Car;

public interface CarDao {
    Car getCarById(Long id);
    Car addCar(Car car);
    void removeCar(Car car);
}
