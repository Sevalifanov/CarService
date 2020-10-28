package com.spring.carService.dao.impl;

import com.spring.carService.dao.CarDao;
import com.spring.carService.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    List<Car> cars = new ArrayList<Car>();

    public Car addCar(Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
            return car;
        }
        return null;

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
