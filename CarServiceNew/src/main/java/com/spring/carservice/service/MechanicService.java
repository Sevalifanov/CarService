package com.spring.carservice.service;

import com.spring.carservice.dto.CarSearchDto;
import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.dto.MechanicSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * MechanicService - класс для работы с уровнем бизнес логикой сущностей Mechanic и MechanicDto.
 */
public interface MechanicService {
    /**
     * Метод добавляющий нового механика в наш persistence layer
     *
     * @param mechanicDto
     * @return -if success -return mechanic, if fail -return null
     */
    MechanicDto add(MechanicDto mechanicDto);

    /**
     * Метод возвращающий объект механик из persistence layer
     *
     * @param id - идентификационный номер механика
     * @return if success -return mechanic, if fail -return null
     */
    MechanicDto getById(Long id);

    /**
     * Метод Удаляющий объект механик из persistence layer
     *
     * @param id - id механик для удаления
     * @return -if success -return true, if fail -return false
     */
    void delete(Long id);

    /**
     * Метод добавляющий нового механика в наш persistence layer
     *
     * @param mechanicDto
     * @return -if success -return mechanic, if fail -return null
     */
    MechanicDto update(MechanicDto mechanicDto);


    /**
     * Метод ищет свободного механика - реализация рандом
     * если механиков нет- вылетает exception
     *
     * @return MechanicDto - механик для заказа
     */
    MechanicDto getFreeMechanic();

    /**
     * @param mechanicSearchDto принимаем модель для поиска
     * @param pageable          параметры для страницы
     * @return список механиков в формате страницы
     */
    Page<MechanicDto> getMechanics(MechanicSearchDto mechanicSearchDto, Pageable pageable);

}
