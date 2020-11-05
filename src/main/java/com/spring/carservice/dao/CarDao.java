package com.spring.carservice.dao;

import com.spring.carservice.model.Car;

public interface CarDao {
    Car getCarById(Long id);
    Car addCar(Car car);
    boolean removeCar(Car car);
}
