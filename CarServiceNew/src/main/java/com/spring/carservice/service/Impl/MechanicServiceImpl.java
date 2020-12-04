package com.spring.carservice.service.Impl;

import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.model.Mechanic;
import com.spring.carservice.service.MechanicService;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@PropertySource("classpath:application.properties")
public class MechanicServiceImpl implements MechanicService {
    private MechanicDao mechanicDao;
    private AsyncProcessService asyncProcessService;

    public MechanicServiceImpl(MechanicDao mechanicDao, AsyncProcessService asyncProcessService) {
        this.mechanicDao = mechanicDao;
        this.asyncProcessService = asyncProcessService;
    }

    @Override
    public Mechanic add(Mechanic mechanic) {
        asyncProcessService.postOperation();
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
