package com.spring.carService.dao.impl;

import com.spring.carService.dao.MechanicDao;
import com.spring.carService.model.Mechanic;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MechanicDaoImpl implements MechanicDao {
    List<Mechanic> mechanics = new ArrayList<>();

    public Mechanic saveMechanic(Mechanic mechanic) {
        if (!mechanics.contains(mechanic)) {
            mechanics.add(mechanic);
            return mechanic;
        }
        return null;
    }

    public void deleteMechanic(Mechanic mechanic) {
        mechanics.remove(mechanic);
    }

    public Mechanic getMechanicById(Long id) {
        for (Mechanic mechanic : mechanics) {
            if (mechanic.getId() == id) {
                return mechanic;
            }
        }
        return null;
    }


}
