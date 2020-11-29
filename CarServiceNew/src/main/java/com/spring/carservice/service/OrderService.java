package com.spring.carservice.service;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.model.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    /**
     * Добавляем  машину в наш сервис на диагностику, Присваиваем механика и цену диагностики
     *
     * @param carDto- принимаем автомобили, которые уже были добавлены в сервис
     * @return Возвращаем заказ-наряд
     */
    OrderDto add(CarDto carDto);

    /**
     * Метод вовзращает заказ наряды по VIN
     *
     * @param id - id автомобиля(VIN)
     * @return возвращает заказ наряд, если такой вин есть, если нет-null
     */
    OrderDto findOrderDtoByCarId(Long id);

    /**
     * Возвращаем список заказ-нарядов
     *
     * @return List<OrderDto>
     */
    List<OrderDto> getOrders();

    /**
     * Когда диагностика автомобиля заканчивается, сервис отдает машину владельцу, заказ закрывается.
     * если такой автомобиль отсутствует сейчас в списке авто на обслуживании, то вылетит эксепшн
     *
     * @param id- Айди автомобиля
     * @return если заказ с таким айди авто есть то вылетит true
     */
    boolean deleteOrderByCarId(Long id);

    /**
     * Данный метод преобразовывает объект типа Order в объект типа OrderDto
     *
     * @param order - Объект типа Order
     * @return OrderDto - Объект типа OrderDto
     */
    OrderDto toDto(Order order);

    /**
     * Метод преобразовывает объект  из OrderDto в стандартный вид Order
     *
     * @param orderDto - Объект типа OrderDto
     * @return Order -Объект типа Order
     */
    Order fromDto(OrderDto orderDto);

}
