package com.spring.carservice.controller;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.model.Car;
import com.spring.carservice.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarController {
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    /**
     * добавляет машину
     * @param carDto
     * @return
     */
    @PostMapping(value = "/addCar")
    public CarDto addCar(@RequestBody CarDto carDto) {
        Car car = carService.add(carService.fromDto(carDto));
        return carService.toDto(car);
    }

    /**
     * Вовзращает машину по айди
     * @param id
     * @return
     */
    @GetMapping(value = "/getCarById")
    public CarDto getCarById(@RequestParam Long id) {
        return carService.toDto(carService.getById(id));
    }

    /**
     * Удаляет машину
     * @param carDto
     */
    @DeleteMapping(value = "/deleteCar")
    public void getCarById(@RequestBody CarDto carDto) {
        carService.delete(carService.fromDto(carDto));
    }


}
