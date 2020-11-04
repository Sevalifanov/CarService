package com.spring.carservice.service;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.model.Order;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    OrderDto add(CarDto carDto);
    OrderDto findOrderDtoByCarId(Long id);
    List<OrderDto> getOrders();
    boolean deleteOrderByCarId(Long id);
    OrderDto toDto(Order order);
    Order fromDto(OrderDto orderDto);

}
