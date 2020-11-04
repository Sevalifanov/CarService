package com.spring.carservice.dao.impl;

import com.spring.carservice.dao.OrderDao;
import com.spring.carservice.model.Order;
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
