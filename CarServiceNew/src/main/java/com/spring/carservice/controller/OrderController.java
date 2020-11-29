package com.spring.carservice.controller;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
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
    @PostMapping(value = "/order")
    public OrderDto addOrder(@RequestBody CarDto carDto) {
        return orderService.add(carDto);
    }

    /**
     * Метод вовзращает заказ наряд по вину авто
     *
     * @param id - VIN машины
     * @return - Вернеться заказ наряд
     */
    @GetMapping(value = "/order")
    public OrderDto getOrderByCarId(@RequestParam Long id) {

        return orderService.findOrderDtoByCarId(id);
    }

    /**
     * Метод удаляет заказ наряд по вину
     *
     * @param id -vin
     * @return стринга со статусом
     */
    @DeleteMapping(value = "/order")
    public void deleteOrderByCarId(@RequestParam Long id) {
        orderService.deleteOrderByCarId(id);
    }
}
