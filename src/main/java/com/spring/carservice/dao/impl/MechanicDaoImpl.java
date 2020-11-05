package com.spring.carservice.dao.impl;

import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.model.Mechanic;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MechanicDaoImpl implements MechanicDao {
    List<Mechanic> mechanics = new ArrayList<>();

    @Override
    public Mechanic saveMechanic(Mechanic mechanic) {
        if (!mechanics.contains(mechanic)) {
            mechanics.add(mechanic);
            return mechanic;
        }
        return null;
    }

    @Override
    public boolean deleteMechanic(Mechanic mechanicR) {
        for (Mechanic mechanic : mechanics) {
            if (mechanic.equals(mechanicR)) {
                return mechanics.remove(mechanic);
            }
        }
        return false;
    }

    @Override
    public Mechanic getMechanicById(Long id) {
        for (Mechanic mechanic : mechanics) {
            if (mechanic.getId() == id) {
                return mechanic;
            }
        }
        return null;
    }

    @Override
    public List<Mechanic> getMechanics() {
        return mechanics;
    }
}
