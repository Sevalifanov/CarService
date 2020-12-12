package com.spring.carservice.dao;

import com.spring.carservice.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrders();

    Order save(Order order);

    Order getById(Long id);

    boolean remove(Order order);
}
