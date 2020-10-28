package com.spring.carService.dao;

import com.spring.carService.model.Mechanic;

public interface MechanicDao {
     Mechanic saveMechanic(Mechanic mechanic);
     void deleteMechanic(Mechanic mechanic);
     Mechanic getMechanicById(Long id);
}
