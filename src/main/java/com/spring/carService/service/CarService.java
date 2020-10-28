package com.spring.carService.service;

import com.spring.carService.dao.CarDao;
import com.spring.carService.dto.CarDto;
import com.spring.carService.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarService {

    private CarDao carDao;


    @Autowired
    public CarService(CarDao carDao) {
        this.carDao = carDao;
    }

    public CarService() {
    }

    public Car fromDto(CarDto carDto) {
        return new Car(
                carDto.getId(),
                carDto.getBrand(),
                carDto.getModelName()
        );
    }

    public CarDto toDto(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModelName()
        );
    }


    public Car add(Car car) {
        carDao.addCar(car);
        return car;
    }

    public Car getById(Long Id) {
        return carDao.getCarById(Id);
    }


    public void delete(Car car) {
        carDao.removeCar(car);
    }


}
