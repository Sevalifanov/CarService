package com.spring.carService.DAO.impl;

import com.spring.carService.DAO.CarDao;
import com.spring.carService.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarDaoImpl implements CarDao {
    List<Car> cars = new ArrayList<Car>();

    public void addCar(Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
        }
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public Car getCarById(Long id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }


}
