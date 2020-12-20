package com.spring.carservice.service;

import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.model.Mechanic;
import com.spring.carservice.service.MechanicService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
@PropertySource("classpath:application.properties")
public class MechanicServiceImpl implements MechanicService {
    private MechanicDao mechanicDao;

    public MechanicServiceImpl(MechanicDao mechanicDao) {
        this.mechanicDao = mechanicDao;
    }

    @Transactional
    @Override
    public MechanicDto add(MechanicDto mechanicDto) {
        return toDto(mechanicDao.save(fromDto(mechanicDto)));
    }

    @Transactional
    @Override
    public MechanicDto getById(Long Id) {
        return toDto(mechanicDao.getById(Id));
    }

    @Transactional
    @Override
    public MechanicDto update(MechanicDto mechanicDto) {
        mechanicDao.remove(mechanicDao.getById(mechanicDto.getId()));
        return toDto(mechanicDao.save(fromDto(mechanicDto)));

    }

    @Transactional
    @Override
    public void delete(Long id) {
        mechanicDao.remove(mechanicDao.getById(id));
    }

    @Transactional
    @Override
    public MechanicDto getFreeMechanic() {
        List<Mechanic> mechanics = mechanicDao.getList();
        Mechanic mechanic;
        if (mechanics.size() > 0) {
            mechanic = mechanics.get(new Random().nextInt(mechanics.size()));
        } else {
            throw new RuntimeException("There is no mechanic in our service. Please add mechanic by /save");
        }
        return toDto(mechanic);
    }

    private Mechanic fromDto(MechanicDto mechanicDto) {
        return new Mechanic(mechanicDto.getId(),
                mechanicDto.getFirstName(),
                mechanicDto.getLastName());
    }

    private MechanicDto toDto(Mechanic mechanic) {
        return new MechanicDto(mechanic.getId(),
                mechanic.getFirstName(),
                mechanic.getLastName());
    }
}
