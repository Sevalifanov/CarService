package com.spring.carservice.controller;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.exeption.NonExistingException;
import com.spring.carservice.service.CarService;
import com.spring.carservice.validator.CarDtoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/v1/car")
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
    @PostMapping
    public ResponseEntity<CarDto> addCar(@RequestBody CarDto carDto, UriComponentsBuilder uriBuilder) {
        carDtoValidator.validate(carDto);
        CarDto car = carService.add(carDto);
        return ResponseEntity.created(uriBuilder.path("/api/v1/car/" + car.getId()).buildAndExpand(car).toUri()).body(car);
    }

    /**
     * Вовзращает машину по айди
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public CarDto getCarById(@PathVariable("id") Long id) {
        return carService.getById(id);
    }

    /**
     * Удаляет машину
     *
     * @param id автомобиля
     */
    @DeleteMapping(value = "/{id}")
    public void deleteCar(@PathVariable("id") Long id) {
        carService.delete(id);
    }

    /**
     * Обновляем информацию по айди автомобиля
     * @param carDto
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public CarDto updateCar(@RequestBody CarDto carDto, @PathVariable("id") Long id) {
        if(!carDto.getId().equals(id)){
            throw new NonExistingException("You tried to update a car did not exist");
        }
        carDtoValidator.validate(carDto);
        return carService.update(carDto);
    }



}
