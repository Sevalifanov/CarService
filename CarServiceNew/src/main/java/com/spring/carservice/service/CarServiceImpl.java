package com.spring.carservice.service;

import com.spring.carservice.repository.CarDao;
import com.spring.carservice.dto.CarDto;
import com.spring.carservice.domain.Car;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarService {

    private CarDao carDao;

    public CarServiceImpl(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public CarDto add(CarDto car) {
        return toDto(carDao.save(fromDto(car)));
    }

    @Transactional
    @Override
    public CarDto getById(Long Id) {
        return toDto(carDao.getById(Id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Car car = carDao.getById(id);
        carDao.remove(car);
    }

    @Transactional
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
