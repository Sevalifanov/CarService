package com.spring.carservice.service;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.CarSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * CarService - класс для работы с уровнем бизнес логикой сущностей Car и CarDto.
 */
public interface CarService {

    /**
     * Метод добавляющий объект автомобиль в наш persistence layer
     *
     * @param car
     * @return -if success -return car, if fail -return null
     */
    CarDto add(CarDto car);

    /**
     * Метод возвращающий объект автомобиль из persistence layer
     *
     * @param Id - идентификационный номер автомобиля
     * @return -if success -return car, if fail -return null
     */
    CarDto getById(Long Id);

    /**
     * Метод Удаляющий объект автомобиль из persistence layer
     *
     * @param id - авто для удаления
     * @return -if success -return true, if fail -return false
     */
    void delete(Long id);

    /**
     * Метод изменяющий объект автомобиль в нашем persistence layer
     *
     * @param carDto
     * @return -if success -return car, if fail -return null
     */
    CarDto update(CarDto carDto);

    /**
     * @param carSearchDto принимаем модель для поиска
     * @param pageable     параметры для страницы
     * @return список автомобилей в формате страницы
     */
    Page<CarDto> getCars(CarSearchDto carSearchDto, Pageable pageable);
}
