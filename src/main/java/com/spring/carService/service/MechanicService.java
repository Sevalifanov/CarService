package com.spring.carService.service;

import com.spring.carService.dao.MechanicDao;
import com.spring.carService.dto.MechanicDto;
import com.spring.carService.model.Mechanic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@PropertySource("classpath:application.properties")
public class MechanicService {
    private MechanicDao mechanicDao;

    @Autowired
    public MechanicService(MechanicDao mechanicDao) {
        this.mechanicDao = mechanicDao;
    }

    @Value("${garage.stuff.mechanic.fisrtname}")
    private String firstName;
    @Value("${garage.stuff.mechanic.lastname}")
    private String lastName;
    @Value("${garage.stuff.mechanic.id}")
    private Long id;

    /**
     * Добавим нашего механика
     */
    @PostConstruct
    private void postConstruct() {
        add(new Mechanic(id, firstName, lastName));
    }

    public boolean add(Mechanic mechanic) {
        mechanicDao.saveMechanic(mechanic);
        return true;
    }

    public Mechanic fromDto(MechanicDto mechanicDto) {
        return new Mechanic(mechanicDto.getId(),
                mechanicDto.getFirstName(),
                mechanicDto.getLastName());
    }

    public MechanicDto toDto(Mechanic mechanic) {
        return new MechanicDto(mechanic.getId(),
                mechanic.getFirstName(),
                mechanic.getLastName());
    }

    public Mechanic getById(Long Id) {
        return mechanicDao.getMechanicById(Id);

    }

    public void delete(Mechanic mechanic) {
        mechanicDao.deleteMechanic(mechanic);
    }


}
