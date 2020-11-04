package com.spring.carservice.service;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.model.Car;

public interface CarService {
   Car fromDto(CarDto carDto);
   CarDto toDto(Car car);
   Car add(Car car);
   Car getById(Long Id);
   void delete(Car car);
}
