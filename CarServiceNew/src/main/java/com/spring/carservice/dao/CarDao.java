package com.spring.carservice.dao;

import com.spring.carservice.model.Car;

import java.util.List;

public interface CarDao {
    Car addCar(Car car);
    boolean removeCar(Car car);
    Car getById(Long id);
    List<Car> getCars();
}
