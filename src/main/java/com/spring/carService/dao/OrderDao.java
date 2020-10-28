package com.spring.carService.dao;

import com.spring.carService.model.Car;
import com.spring.carService.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrders();
    Order saveOrder(Order order);
    boolean deleteOrder(Order order);
}
