package com.spring.carservice.dao.mapper;

import com.spring.carservice.model.Car;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarRowMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int i) throws SQLException {
        final Car car = new Car();
        car.setId(Long.valueOf(rs.getString("id")));
        car.setBrand(rs.getString("brand"));
        car.setModelName(rs.getString("model_name"));
        return car;
    }

}
