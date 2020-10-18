package com.spring.carService.DAO.impl;

import com.spring.carService.DAO.OrderDao;
import com.spring.carService.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Repository
public class OrderDaoImpl implements OrderDao {
    List<Order> orders = new ArrayList<>();

    @Override
    public void saveOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void deleteOrder(Order order) {
        orders.remove(order);
    }

    @Override
    public Order getOrderByDate(Date date) {
        for(Order order: orders){
            if(order.getPublicationDate().equals(date)){
                return order;
            }
        }
        return null;
    }
}
