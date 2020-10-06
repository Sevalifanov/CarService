package com.spring.carService.DAO;

import com.spring.carService.model.Car;

public interface CarDao {
     Car getCarById(Long id);
     void addCar(Car car);
     void removeCar(Car car);
}
