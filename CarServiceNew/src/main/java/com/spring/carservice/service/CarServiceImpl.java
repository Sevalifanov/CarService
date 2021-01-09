package com.spring.carservice.service;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.domain.Car;
import com.spring.carservice.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    @Override
    public CarDto add(CarDto car) {
        return toDto(carRepository.save(fromDto(car)));
    }

    @Transactional
    @Override
    public CarDto getById(Long Id) {
        return toDto(carRepository.getOne(Id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Car car = carRepository.getOne(id);
        carRepository.delete(car);
    }

    @Transactional
    @Override
    public CarDto update(CarDto carDto) {
        return toDto(carRepository.save(fromDto(carDto)));
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
