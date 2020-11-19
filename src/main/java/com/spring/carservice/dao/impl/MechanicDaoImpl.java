package com.spring.carservice.dao.impl;

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
    public Mechanic saveMechanic(Mechanic mechanic) {
        addMechanicJdbcInsert(mechanic);
        return mechanic;
    }

    @Override
    public boolean deleteMechanic(Mechanic mechanic) {
        if (deleteFromMechanic(mechanic.getId()) >= 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Mechanic getMechanicById(Long id) {
        return getById(id);
    }

    @Override
    public List<Mechanic> getMechanics() {
        Collection<Mechanic> mechanics =  jdbcTemplate.query("SELECT * FROM mechanic", new MechanicRowMapper());
        ArrayList<Mechanic> mechanicArrayList = new ArrayList<>();
        mechanics.forEach(mechanic -> mechanicArrayList.add(mechanic));
        return mechanicArrayList;
    }

    @Override
    public Mechanic getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM mechanic WHERE id = ?", new Object[]{id}, new MechanicRowMapper());
    }


    @Override
    public int addMechanicJdbcInsert(Mechanic mechanic) {
        final Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", mechanic.getId());
        parameters.put("first_name", mechanic.getFirstName());
        parameters.put("last_name", mechanic.getLastName());
        return simpleJdbcInsert.execute(parameters);
    }

    @Override
    public int deleteFromMechanic(Long id) {
        return jdbcTemplate.update("DELETE FROM mechanic WHERE id = ?;", new Object[]{id});
    }
}
