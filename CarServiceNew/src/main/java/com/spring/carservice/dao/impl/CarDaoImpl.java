package com.spring.carservice.dao.impl;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.model.Car;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarDaoImpl implements CarDao {
    List<Car> cars = new ArrayList<>();

    @Override
    public Car addCar(Car car) {
        for (Car carR : cars) {
            if (carR.equals(car)) {
                return null;
            }
        }
        cars.add(car);
        return car;
    }

    @Override
    public boolean removeCar(Car car) {
        return cars.remove(car);
    }


    @Override
    public Car getById(Long id) {
        for (Car car : cars) {
            if (car.getId() == id) return car;
        }
        return null;
    }

    public List<Car> getCars() {
        return cars;
    }
}
