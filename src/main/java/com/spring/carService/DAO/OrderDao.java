package com.spring.carService.DAO;

import com.spring.carService.model.Order;

import java.util.Date;

public interface OrderDao {
    void saveOrder(Order order);
    void deleteOrder(Order order);
    Order getOrderByDate(Date date);
}
