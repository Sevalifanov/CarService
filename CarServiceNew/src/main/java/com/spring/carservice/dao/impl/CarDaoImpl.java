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
    public Car save(Car car) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", car.getId());
        parameters.put("brand", car.getBrand());
        parameters.put("model_name", car.getModelName());
        simpleJdbcInsert.execute(parameters);
        return car;
    }

    @Override
    public void remove(Car car) {
        jdbcTemplate.update("DELETE FROM car WHERE id = ?, brand = ?, model_name = ?",
                new Object[]{car.getId(), car.getBrand(), car.getModelName()});
    }


    @Override
    public Car getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM car WHERE id = ?", new Object[]{id}, new CarRowMapper());
    }

    public List<Car> getCars() {
        return jdbcTemplate.query("SELECT * FROM car", new CarRowMapper());
    }
}
