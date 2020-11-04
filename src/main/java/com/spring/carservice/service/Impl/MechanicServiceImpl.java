package com.spring.carservice.service.Impl;

import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.model.Mechanic;
import com.spring.carservice.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;

@Service
@PropertySource("classpath:application.properties")
public class MechanicServiceImpl implements MechanicService {
    private MechanicDao mechanicDao;

    @Autowired
    public MechanicServiceImpl(MechanicDao mechanicDao) {
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

    public Mechanic add(Mechanic mechanic) {
        return mechanicDao.saveMechanic(mechanic);

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

    public MechanicDto getFreeMechanic(){
        int size = mechanicDao.getMechanics().size();
        Mechanic mechanic;
        if(size>0){
            mechanic =  mechanicDao.getMechanicById(
               Long.valueOf (new Random().nextInt(size)));}
        else {throw new RuntimeException("There is no mechanic in our service. Please add mechanic by /addMechanic");};
        return toDto(mechanic);
    }



}
