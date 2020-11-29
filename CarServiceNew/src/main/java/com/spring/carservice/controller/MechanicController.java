package com.spring.carservice.controller;

import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.model.Mechanic;
import com.spring.carservice.service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MechanicController {
    private MechanicService mechanicService;

    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    /**
     * Добавляем автомобили
     *
     * @param mechanicDto
     * @return
     */
    @PostMapping(value = "/mechanic")
    public MechanicDto addMechanic(@RequestBody MechanicDto mechanicDto) {
        Mechanic mechanic = mechanicService.add(mechanicService.fromDto(mechanicDto));
        return mechanicService.toDto(mechanic);
    }

    /**
     * Возвращает механика по айди
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/mechanic")
    public MechanicDto getMechanicById(@RequestParam Long id) {
        return mechanicService.toDto(mechanicService.getById(id));
    }

    /**
     * Удаляет механика
     *
     * @param mechanicDto
     */
    @DeleteMapping(value = "/mechanic")
    public void deleteMechanic(@RequestBody MechanicDto mechanicDto) {
        mechanicService.delete(mechanicService.fromDto(mechanicDto));
    }


}
