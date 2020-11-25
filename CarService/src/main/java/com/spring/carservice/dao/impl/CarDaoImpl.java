package com.spring.carservice.dao.impl;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.dao.mapper.CarRowMapper;
import com.spring.carservice.model.Car;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CarDaoImpl implements CarDao {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public CarDaoImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("car");
    }

    @Override
    public Car addCar(Car car) {
        addCarJdbcInsert(car);
        return car;
    }

    @Override
    public boolean removeCar(Car car) {
        if (deleteFromCar(car.getId()) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Car getCarById(Long id) {
        return getById(id);
    }

    @Override
    public Car getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE id = ?", new Object[]{id}, new CarRowMapper());
    }

    @Override
    public int addCarJdbcInsert(Car car) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", car.getId());
        parameters.put("brand", car.getBrand());
        parameters.put("model_name", car.getModelName());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public int deleteFromCar(Long id) {
        return jdbcTemplate.update("DELETE FROM car WHERE id = ?;", new Object[]{id});
    }


}
