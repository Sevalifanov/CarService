package com.spring.carservice.dao;

import com.spring.carservice.model.Mechanic;

import java.util.List;

public interface MechanicDao {
    Mechanic save(Mechanic mechanic);

    void remove(Mechanic mechanic);

    List<Mechanic> getList();

    Mechanic getById(Long id);
}
