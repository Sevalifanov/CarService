package com.spring.carService.DAO;

import com.spring.carService.model.Car;
import com.spring.carService.model.Mechanic;

public interface MechanicDao {
     void saveMechanic(Mechanic mechanic);
     void deleteMechanic(Mechanic mechanic);
     Mechanic getMechanicById(Long id);
     void addCarToMechanic(Mechanic mechanic, Car car);
}
