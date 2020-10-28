package com.spring.carService.dao.impl;

import com.spring.carService.dao.OrderDao;
import com.spring.carService.model.Car;
import com.spring.carService.model.Order;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    List<Order> orders = new ArrayList<>();

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public Order saveOrder(Order order) {
        if (!orders.contains(order)) {
            orders.add(order);
            return order;
        }
        return null;
    }

    @Override
    public boolean deleteOrder(Order order) {
        return orders.remove(order);
    }

}
