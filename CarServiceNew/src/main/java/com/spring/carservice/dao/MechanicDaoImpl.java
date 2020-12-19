package com.spring.carservice.dao;

import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dao.mapper.MechanicRowMapper;
import com.spring.carservice.model.Mechanic;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MechanicDaoImpl implements MechanicDao {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    public MechanicDaoImpl(JdbcTemplate jdbcTemplate, SimpleJdbcInsert simpleJdbcInsert) {
        this.jdbcTemplate = jdbcTemplate;
        this.simpleJdbcInsert = simpleJdbcInsert;
        simpleJdbcInsert.withTableName("mechanic");
    }

    @Override
    public Mechanic save(Mechanic mechanic) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", mechanic.getId());
        parameters.put("first_name", mechanic.getFirstName());
        parameters.put("last_name", mechanic.getLastName());
        simpleJdbcInsert.execute(parameters);
        return mechanic;
    }

    @Override
    public void remove(Mechanic mechanic) {
        jdbcTemplate.update("DELETE FROM mechanic WHERE id = ?, first_name = ?, last_name = ?",
                new Object[]{mechanic.getId(), mechanic.getFirstName(), mechanic.getLastName()});
    }

    @Override
    public Mechanic getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM mechanic WHERE id = ?", new Object[]{id}, new MechanicRowMapper());
    }

    @Override
    public List<Mechanic> getList() {
        return jdbcTemplate.query("SELECT * FROM mechanic", new MechanicRowMapper());
    }



}
