package com.spring.carservice.dao;

import com.spring.carservice.model.Car;

import java.util.List;
//todo save
public interface CarDao {
    Car save(Car car);

    void remove(Car car);

    Car getById(Long id);

    List<Car> getCars();
}
