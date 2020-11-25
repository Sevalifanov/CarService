package com.spring.carservice.service.Impl;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.model.Car;
import com.spring.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;


    @Autowired
    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;

    }

    public CarServiceImpl() {
    }

    @Override
    public Car fromDto(CarDto carDto) {
        return new Car(
                carDto.getId(),
                carDto.getBrand(),
                carDto.getModelName()
        );
    }

    @Override
    public CarDto toDto(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModelName()
        );
    }

    @Override
    @Transactional
    public Car add(Car car) {
        carDao.addCar(car);
        return car;
    }

    @Override
    @Transactional
    public Car getById(Long Id) {
        return carDao.getCarById(Id);
    }

    @Override
    @Transactional
    public boolean delete(Car car) {
        return carDao.removeCar(car);
    }


}
