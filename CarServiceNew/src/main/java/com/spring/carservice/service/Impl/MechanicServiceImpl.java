package com.spring.carservice.service.Impl;

import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.model.Mechanic;
import com.spring.carservice.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@PropertySource("classpath:application.properties")
public class MechanicServiceImpl implements MechanicService {
    private MechanicDao mechanicDao;

    @Autowired
    public MechanicServiceImpl(MechanicDao mechanicDao) {
        this.mechanicDao = mechanicDao;
    }

    @Override
    public Mechanic add(Mechanic mechanic) {
        return mechanicDao.addMechanic(mechanic);

    }

    @Override
    public Mechanic fromDto(MechanicDto mechanicDto) {
        return new Mechanic(mechanicDto.getId(),
                mechanicDto.getFirstName(),
                mechanicDto.getLastName());
    }

    @Override
    public MechanicDto toDto(Mechanic mechanic) {
        return new MechanicDto(mechanic.getId(),
                mechanic.getFirstName(),
                mechanic.getLastName());
    }

    @Override
    public Mechanic getById(Long Id) {
        return mechanicDao.getById(Id);

    }

    @Override
    public boolean delete(Mechanic mechanic) {
        return mechanicDao.deleteMechanic(mechanic);
    }

    /**
     * Метод ищет свободного механика - реализация рандом
     * если механиков нет- вылетает exception
     * @return механик для заказа
     */
    @Override
    public MechanicDto getFreeMechanic() {
        List<Mechanic> mechanics = mechanicDao.getMechanics();
        Mechanic mechanic;
        if (mechanics.size() > 0) {
            mechanic = mechanics.get(new Random().nextInt(mechanics.size()));
        } else {
            throw new RuntimeException("There is no mechanic in our service. Please add mechanic by /addMechanic");
        }
        return toDto(mechanic);
    }


}