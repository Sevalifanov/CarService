package com.spring.carservice.controller;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.model.Car;
import com.spring.carservice.service.CarService;
import com.spring.carservice.validator.CarDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    private CarService carService;
    private CarDtoValidator carDtoValidator;

    public CarController(CarService carService, CarDtoValidator carDtoValidator) {
        this.carService = carService;
        this.carDtoValidator = carDtoValidator;
    }

    /**
     * добавляет машину в список машин приезжающих на сервис
     *
     * @param carDto
     * @return
     */
    @PostMapping(value = "/car")
    public CarDto addCar(@RequestBody CarDto carDto) {
        carDtoValidator.validate(carDto);
        Car car = carService.add(carService.fromDto(carDto));
        return carService.toDto(car);
    }

    /**
     * Вовзращает машину по айди
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/car")
    public CarDto getCarById(@RequestParam Long id) {
        return carService.toDto(carService.getById(id));
    }

    /**
     * Удаляет машину
     *
     * @param carDto
     */
    @DeleteMapping(value = "/car")
    public void deleteCar(@RequestBody CarDto carDto) {
        carService.delete(carService.fromDto(carDto));
    }


}
