package com.spring.carservice.service;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.dto.CarDto;
import com.spring.carservice.model.Car;
import com.spring.carservice.service.CarService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public CarDto add(CarDto car) {
        return toDto(carDao.save(fromDto(car)));
    }

    @Override
    public CarDto getById(Long Id) {
        return toDto(carDao.getById(Id));
    }

    @Override
    public boolean delete(Long id) {
        Car car = carDao.getById(id);
        return carDao.remove(car);
    }

    @Override
    public CarDto update(CarDto carDto) {
        carDao.remove(carDao.getById(carDto.getId()));
        return toDto(carDao.save(fromDto(carDto)));
    }

    private Car fromDto(CarDto carDto) {
        return new Car(
                carDto.getId(),
                carDto.getBrand(),
                carDto.getModelName()
        );
    }

    private CarDto toDto(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModelName()
        );
    }

}
