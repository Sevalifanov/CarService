package com.spring.carservice.service;

import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.model.Mechanic;

/**
 * MechanicService - класс для работы с уровнем бизнес логикой сущностей Mechanic и MechanicDto.
 */
public interface MechanicService {
    /**
     * Метод добавляющий нового механика в наш persistence layer
     *
     * @param mechanic
     * @return -if success -return mechanic, if fail -return null
     */
    Mechanic add(Mechanic mechanic);

    /**
     * Метод преобразовывает объект  из MechanicDto в стандартный вид Mechanic
     *
     * @param mechanicDto - Объект типа CarDto
     * @return Mechanic -Объект типа Car
     */
    Mechanic fromDto(MechanicDto mechanicDto);

    /**
     * Данный метод преобразовывает объект типа Mechanic в объект типа MechanicDto
     *
     * @param mechanic - Объект типа Mechanic
     * @return MechanicDto - Объект типа MechanicDto
     */
    MechanicDto toDto(Mechanic mechanic);

    /**
     * Метод возвращающий объект механик из persistence layer
     *
     * @param Id - идентификационный номер механика
     * @return if success -return mechanic, if fail -return null
     */
    Mechanic getById(Long Id);

    /**
     * Метод Удаляющий объект механик из persistence layer
     *
     * @param mechanic - механик для удаления
     * @return -if success -return true, if fail -return false
     */
    boolean delete(Mechanic mechanic);

    /**
     * Метод ищет свободного механика - реализация рандом
     * если механиков нет- вылетает exception
     *
     * @return MechanicDto - механик для заказа
     */
    MechanicDto getFreeMechanic();
}
