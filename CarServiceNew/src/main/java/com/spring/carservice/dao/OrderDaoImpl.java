package com.spring.carservice.dao;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dao.OrderDao;
import com.spring.carservice.dao.mapper.OrderRowMapper;
import com.spring.carservice.model.Order;
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
    public Order save(Order order) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", order.getId());
        parameters.put("publication_date", order.getPublicationDate().toString());
        parameters.put("car_id", order.getCar().getId());
        parameters.put("mechanic_id", order.getMechanic().getId());
        parameters.put("price", order.getPrice());
        simpleJdbcInsert.execute(parameters);
        return order;
    }

    @Override
    public Order getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM orders WHERE id = ?", new Object[]{id}, new OrderRowMapper());
    }

    @Override
    public void remove(Order order) {
        jdbcTemplate.update("DELETE FROM orders WHERE id = ?, publication_date = ?, car_id = ?, mechanic_id = ?, price = ?",
                new Object[]{order.getId(),
                order.getPublicationDate().toString(),
                order.getCar().getId(),
                order.getMechanic().getId(),
                order.getPrice()});
    }
    @Override
    public List<Order> getList() {
        return jdbcTemplate.query("SELECT * FROM orders", new OrderRowMapper());
    }

}
