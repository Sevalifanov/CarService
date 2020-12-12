package com.spring.carservice.dao;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dao.OrderDao;
import com.spring.carservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class OrderDaoImpl implements OrderDao {
    List<Order> orders = new ArrayList<>();
    private CarDao carDao;
    private MechanicDao mechanicDao;

    @Autowired
    public OrderDaoImpl(CarDao carDao, MechanicDao mechanicDao) {
        this.carDao = carDao;
        this.mechanicDao = mechanicDao;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public Order save(Order order) {
        orders.add(order);
        return order;
    }

    @Override
    public Order getById(Long id) {
        for(Order order: orders){
            if(order.getId().equals(id))return order;
        }
        return null;
    }

    @Override
    public boolean remove(Order order) {
        return orders.remove(order);
    }


}
