package com.spring.carService.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.spring.carService.dto.CarDto;
import com.spring.carService.dto.OrderDto;
import com.spring.carService.service.CarService;
import com.spring.carService.service.MechanicService;
import com.spring.carService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@PropertySource("classpath:application.properties")
@RestController
public class Controller {
    private MechanicService mechanicService;
    private CarService carService;
    private OrderService orderService;

    @Autowired
    public Controller(MechanicService mechanicService, CarService carService, OrderService orderService) {
        this.mechanicService = mechanicService;
        this.carService = carService;
        this.orderService = orderService;
    }

    @GetMapping
    public String greeting() throws IOException {
        return "welcome to garage ";
    }

    /**
     * Этот метод добавляет новую машину
     *
     * @param carDto "{"id":укажи VIN,
     *               "brand":"укажи бренд",
     *               "modelName":"укажи модель"}"
     * @return OrderDto -заказ наряд возвращаем клиенту.
     */
    @PostMapping(value = "/addNew")
    public OrderDto addNewOrder(@RequestBody CarDto carDto) {
        return orderService.add(carDto);
    }

    /**
     * Метод вовзращает заказ наряд по вину авто
     *
     * @param id - VIN машины
     * @return - Вернеться заказ наряд
     */
    @GetMapping(value = "/getByVIN")
    public OrderDto getOrderByCarId(@RequestParam Long id) {
        return orderService.findOrderDtoByCarId(id);
    }

    /**
     * Метод удаляет заказ наряд по вину
     *
     * @param id -vin
     * @return стринга со статусом
     */

    @DeleteMapping(value = "/deleteByVIN")
    public String deleteByVIN(@RequestParam Long id) {
        if (orderService.deleteOrderByCarId(id)) {
            return "Order has been deleted";
        }
        return "This order has been absent";
    }
}
