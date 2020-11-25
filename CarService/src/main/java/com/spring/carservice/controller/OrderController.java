package com.spring.carservice.controller;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderServiceImpl) {
        this.orderService = orderServiceImpl;
    }
    /**
     * Этот метод добавляет новую машину
     *
     * @param carDto "{"id":укажи VIN,
     *               "brand":"укажи бренд",
     *               "modelName":"укажи модель"}"
     * @return OrderDto -заказ наряд возвращаем клиенту.
     */
    @PostMapping(value = "/addOrder")
    public OrderDto addOrder(@RequestBody CarDto carDto) {
        return orderService.add(carDto);
    }

    /**
     * Метод вовзращает заказ наряд по вину авто
     *
     * @param id - VIN машины
     * @return - Вернеться заказ наряд
     */
    @GetMapping(value = "/getOrderByCarId")
    public OrderDto getOrderByCarId(@RequestParam Long id) {

        return orderService.findOrderDtoByCarId(id);
    }

    /**
     * Метод удаляет заказ наряд по вину
     *
     * @param id -vin
     * @return стринга со статусом
     */

    @DeleteMapping(value = "/deleteOrderByCarId")
    public Boolean deleteOrderByCarId(@RequestParam Long id) {
        return orderService.deleteOrderByCarId(id);
    }
}
