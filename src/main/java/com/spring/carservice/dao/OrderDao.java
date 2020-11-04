package com.spring.carservice.dao;

import com.spring.carservice.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getOrders();
    Order saveOrder(Order order);
    boolean deleteOrder(Order order);
}
