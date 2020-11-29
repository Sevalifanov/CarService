package com.spring.carservice.service;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.model.Car;

/**
 * CarService - класс для работы с уровнем бизнес логикой сущностей Car и CarDto.
 */
public interface CarService {
    /**
     * Метод преобразовывает объект  из CarDto в стандартный вид Car
     *
     * @param carDto - Объект типа CarDto
     * @return Car -Объект типа Car
     */
    Car fromDto(CarDto carDto);

    /**
     * Данный метод преобразовывает объект типа Car в объект типа CarDto
     *
     * @param car - Объект типа car
     * @return CarDto - Объект типа CarDto
     */
    CarDto toDto(Car car);

    /**
     * Метод добавляющий объект автомобиль в наш persistence layer
     *
     * @param car
     * @return -if success -return car, if fail -return null
     */
    Car add(Car car);

    /**
     * Метод возвращающий объект автомобиль из persistence layer
     *
     * @param Id - идентификационный номер автомобиля
     * @return -if success -return car, if fail -return null
     */
    Car getById(Long Id);

    /**
     * Метод Удаляющий объект автомобиль из persistence layer
     *
     * @param car - авто для удаления
     * @return -if success -return true, if fail -return false
     */
    boolean delete(Car car);
}
