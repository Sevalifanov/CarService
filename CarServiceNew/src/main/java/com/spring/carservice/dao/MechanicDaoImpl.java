package com.spring.carservice.dao;

import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.model.Mechanic;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MechanicDaoImpl implements MechanicDao {
    List<Mechanic> mechanics = new ArrayList<>();

    @Override
    public Mechanic save(Mechanic mechanic) {
        for (Mechanic mechanicR : mechanics) {
            if (mechanicR.equals(mechanic)) {
                return null;
            }
        }
        mechanics.add(mechanic);
        return mechanic;
    }

    @Override
    public boolean remove(Mechanic mechanic) {
        return mechanics.remove(mechanic);
    }

    @Override
    public List<Mechanic> getList() {
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
