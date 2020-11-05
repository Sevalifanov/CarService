package com.spring.carservice.dao.impl;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    List<Car> cars = new ArrayList<Car>();
    @Override
    public Car addCar(Car car) {
        if (!cars.contains(car)) {
            cars.add(car);
            return car;
        }
        return null;

    }
    @Override
    public boolean removeCar(Car carR) {
        for(Car car: cars){
            if(car.equals(carR)){return cars.remove(car);}
        }
        return false;
    }
    @Override
    public Car getCarById(Long id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }


}
