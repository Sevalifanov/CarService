package com.spring.carservice.dao.impl;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dao.OrderDao;
import com.spring.carservice.dao.mapper.MechanicRowMapper;
import com.spring.carservice.dao.mapper.OrderRowMapper;
import com.spring.carservice.model.Mechanic;
import com.spring.carservice.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public class OrderDaoImpl implements OrderDao {
    private CarDao carDao;
    private MechanicDao mechanicDao;
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public OrderDaoImpl(CarDao carDao, MechanicDao mechanicDao, JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.carDao = carDao;
        this.mechanicDao = mechanicDao;
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("orders");
    }

    @Override
    public List<Order> getOrders() {
        List<Order> orders =  jdbcTemplate.query("SELECT * FROM orders", new OrderRowMapper());
        ArrayList<Order> orderArrayList = new ArrayList<>();
        orders.forEach(order -> orderArrayList.add(new Order(order.getPublicationDate(),
                carDao.getCarById(order.getCar().getId()),
                mechanicDao.getMechanicById(order.getMechanic().getId()),
                order.getPrice())));
        return orderArrayList;
    }

    @Override
    public Order saveOrder(Order order) {
        addOrderJdbcInsert(order);
        return order;
    }

    @Override
    public boolean deleteOrder(Order order) {
        if (deleteFromOrder(order.getPublicationDate().getTime()) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Order getByDate(Long milis) {
        Order order = jdbcTemplate.queryForObject("SELECT * FROM orders WHERE publication_date = ?", new Object[]{milis}, new OrderRowMapper());
        return new Order(order.getPublicationDate(),
                carDao.getCarById(order.getCar().getId()),
                mechanicDao.getMechanicById(order.getMechanic().getId()),
                order.getPrice());
    }

    @Override
    public int addOrderJdbcInsert(Order order) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("publication_date", order.getPublicationDate().getTime());
        parameters.put("car_id", order.getCar().getId());
        parameters.put("mechanic_id", order.getMechanic().getId());
        parameters.put("price", order.getPrice());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public int deleteFromOrder(Long milis) {
        return jdbcTemplate.update("DELETE FROM orders WHERE publication_date = ?", new Object[]{milis});
    }


}
