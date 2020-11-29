package com.spring.carservice.service.Impl;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.dto.CarDto;
import com.spring.carservice.model.Car;
import com.spring.carservice.service.AsyncProcessService;
import com.spring.carservice.service.CarService;
import org.springframework.stereotype.Service;


@Service
public class CarServiceImpl implements CarService {

    private AsyncProcessService asyncProcessService;
    private CarDao carDao;

    public CarServiceImpl(AsyncProcessService asyncProcessService, CarDao carDao) {
        this.asyncProcessService = asyncProcessService;
        this.carDao = carDao;
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
    public Car add(Car car) {
        asyncProcessService.postOperation();
        return carDao.addCar(car);

    }

    @Override
    public Car getById(Long Id) {
        return carDao.getById(Id);
    }

    @Override
    public boolean delete(Car car) {
        return carDao.removeCar(car);
    }


}
