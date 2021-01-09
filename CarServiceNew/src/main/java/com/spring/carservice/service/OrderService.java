package com.spring.carservice.service;

import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.dto.OrderSearchDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * MechanicService - интерфейс содержащий методы для работы с уровнем бизнес логикой сущностей Mechanic и MechanicDto.
 */
public interface OrderService {
    /**
     * Добавляем  машину в наш сервис на диагностику, Присваиваем механика и цену диагностики
     *
     * @param orderDto- принимаем автомобили, которые уже были добавлены в сервис
     * @return Возвращаем заказ-наряд
     */
    OrderDto add(OrderDto orderDto);

    /**
     * Метод вовзращает заказ наряды по id
     *
     * @param id - id автомобиля(VIN)
     * @return возвращает заказ наряд, если такой вин есть, если нет-null
     */
    OrderDto getById(Long id);

    /**
     * Возвращаем список заказ-нарядов
     *
     * @return List<OrderDto>
     */
    List<OrderDto> getOrders();

    /**
     * обновляет информацию о заказе
     *
     * @param orderDto- обновляем инфу о заказ наряде
     * @return Возвращаем заказ-наряд
     */
    OrderDto update(OrderDto orderDto);

    /**
     * Метод Удаляющий заказ наряд из persistence layer
     *
     * @param id - id заказа для удаления
     * @return -if success -return true, if fail -return false
     */
    void deleteById(Long id);

    /**
     * @param orderSearchDto принимаем модель для поиска
     * @param pageable       параметры для страницы
     * @return список заказов в формате страницы
     */
    Page<OrderDto> getOrders(OrderSearchDto orderSearchDto, Pageable pageable);

}