package com.spring.carservice.dao.mapper;

import com.spring.carservice.model.Mechanic;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MechanicRowMapper implements RowMapper<Mechanic> {
    @Override
    public Mechanic mapRow(ResultSet rs, int i) throws SQLException {
        final Mechanic mechanic = new Mechanic();
        mechanic.setId(Long.valueOf(rs.getString("id")));
        mechanic.setFirstName(rs.getString("first_name"));
        mechanic.setLastName(rs.getString("last_name"));
        return mechanic;
    }

}