package com.spring.carservice.service;

import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.model.Mechanic;

public interface MechanicService {
    Mechanic add(Mechanic mechanic);

    Mechanic fromDto(MechanicDto mechanicDto);

    MechanicDto toDto(Mechanic mechanic);

    Mechanic getById(Long Id);

    boolean delete(Mechanic mechanic);

    MechanicDto getFreeMechanic();
}
