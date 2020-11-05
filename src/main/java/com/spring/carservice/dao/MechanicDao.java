package com.spring.carservice.dao;

import com.spring.carservice.model.Mechanic;

import java.util.List;

public interface MechanicDao {
     Mechanic saveMechanic(Mechanic mechanic);
     boolean deleteMechanic(Mechanic mechanic);
     Mechanic getMechanicById(Long id);
     List<Mechanic> getMechanics();
}
