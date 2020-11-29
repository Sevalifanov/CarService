package com.spring.carservice.dao;


import com.spring.carservice.model.Mechanic;

import java.util.List;

public interface MechanicDao {
    Mechanic addMechanic(Mechanic mechanic);

    boolean deleteMechanic(Mechanic mechanic);

    List<Mechanic> getMechanics();

    Mechanic getById(Long id);
}
