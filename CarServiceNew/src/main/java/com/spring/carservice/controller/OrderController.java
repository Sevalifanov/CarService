package com.spring.carservice.controller;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.ZoneOffset;


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
    public ResponseEntity<OrderDto> addOrder(@RequestBody CarDto carDto, UriComponentsBuilder uriBuilder) {
        OrderDto orderDto = orderService.add(carDto);
        return ResponseEntity.created(uriBuilder.path("/api/v1/order/" + orderDto.getPublicationDate().toEpochSecond(ZoneOffset.UTC))
                .buildAndExpand(orderDto).toUri()).body(orderDto);
    }

    /**
     * Метод вовзращает заказ наряд по вину авто
     *
     * @param id - VIN машины
     * @return - Вернеться заказ наряд
     */
    @GetMapping(value = "/{id}")
    public OrderDto getOrderById(@PathVariable("id") Long id) {
        return orderService.getById(id);
    }

    /**
     * Метод удаляет заказ наряд по вину
     *
     * @param id -vin автомобиля
     * @return стринга со статусом
     */
    @DeleteMapping(value = "/{id}")
    public void deleteOrderId(@PathVariable("id") Long id) {
        orderService.delete(id);
    }

    /**
     * Обновлем информацию о заказ наряде
     *
     * @param orderDto - изменения заказ наряда
     * @param id       - id нужного заказа
     * @return
     */
    @PutMapping(value = "/{id}")
    public OrderDto updateCar(@RequestBody OrderDto orderDto, @PathVariable("id") Long id) {
        if (!orderDto.getId().equals(id)) {
            throw new RuntimeException();
        }
        orderService.update(orderDto);
        return orderDto;
    }

}
