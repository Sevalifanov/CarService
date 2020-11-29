package com.spring.carservice.dao;

import com.spring.carservice.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrders();

    Order addOrder(Order order);

    boolean deleteOrder(Order order);

    Order getByDate(Long milis);

    boolean deleteFromOrderByDate(Long id);
}
