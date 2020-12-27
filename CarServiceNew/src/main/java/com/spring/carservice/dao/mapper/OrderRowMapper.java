package com.spring.carservice.dao.mapper;

import com.spring.carservice.model.Car;
import com.spring.carservice.model.Mechanic;
import com.spring.carservice.model.Order;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Date;


public class OrderRowMapper implements RowMapper<Order> {
    @Override
    public Order mapRow(ResultSet rs, int i) throws SQLException {
        final Order order = new Order();
        order.setId(Long.valueOf(rs.getString("id")));
        order.setPublicationDate(LocalDateTime.parse(rs.getString("publication_date")));
        order.setCar(new Car(Long.valueOf(rs.getString("car_id"))));
        order.setMechanic(new Mechanic(Long.valueOf(rs.getString("mechanic_id"))));
        order.setPrice(BigDecimal.valueOf(rs.getDouble("price")));
        return order;
    }

}