package com.spring.carservice.controller;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderServiceImpl) {
        this.orderService = orderServiceImpl;
    }

    /**
     * Этот метод добавляет новую машину
     *
     * @param carDto
     * @return OrderDto -заказ наряд возвращаем клиенту.
     */
    @PostMapping
    public OrderDto addOrder(@RequestBody CarDto carDto) {
        return orderService.add(carDto);
    }

    /**
     * Метод вовзращает заказ наряд по вину авто
     *
     * @param id - VIN машины
     * @return - Вернеться заказ наряд
     */
    @GetMapping(value = "/{id}")
    public OrderDto getOrderByCarId(@PathVariable("id") Long id) {
        return orderService.findOrderDtoByCarId(id);
    }

    /**
     * Метод удаляет заказ наряд по вину
     *
     * @param id -vin автомобиля
     * @return стринга со статусом
     */
    @DeleteMapping(value = "/{id}")
    public void deleteOrderByCarId(@PathVariable("id") Long id) {
        orderService.deleteOrderByCarId(id);
    }
}
