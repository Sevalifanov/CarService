package com.spring.carservice.dao.impl;

import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.model.Mechanic;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MechanicDaoImpl implements MechanicDao {
    List<Mechanic> mechanics = new ArrayList<>();

    @Override
    public Mechanic addMechanic(Mechanic mechanic) {
        for (Mechanic mechanicR : mechanics) {
            if (mechanicR.equals(mechanic)) {
                return null;
            }
        }
        mechanics.add(mechanic);
        return mechanic;
    }

    @Override
    public boolean deleteMechanic(Mechanic mechanic) {
        return mechanics.remove(mechanic);
    }

    @Override
    public List<Mechanic> getMechanics() {
        return mechanics;
    }

    @Override
    public Mechanic getById(Long id) {
        for(Mechanic mechanic: mechanics){
            if(mechanic.getId() == id)return mechanic;
        }
        return null;
    }


}
