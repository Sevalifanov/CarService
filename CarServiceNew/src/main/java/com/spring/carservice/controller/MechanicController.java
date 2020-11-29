package com.spring.carservice.controller;

import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.model.Mechanic;
import com.spring.carservice.service.MechanicService;
import com.spring.carservice.validator.MechanicDtoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/mechanic")
public class MechanicController {
    private MechanicService mechanicService;
    private MechanicDtoValidator mechanicDtoValidator;

    public MechanicController(MechanicService mechanicService, MechanicDtoValidator mechanicDtoValidator) {
        this.mechanicService = mechanicService;
        this.mechanicDtoValidator = mechanicDtoValidator;
    }

    /**
     * Добавляем автомобили
     *
     * @param mechanicDto
     * @return
     */
    @PostMapping
    public MechanicDto addMechanic(@RequestBody MechanicDto mechanicDto) {
        mechanicDtoValidator.validate(mechanicDto);
        Mechanic mechanic = mechanicService.add(mechanicService.fromDto(mechanicDto));
        return mechanicService.toDto(mechanic);
    }

    /**
     * Возвращает механика по айди
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public MechanicDto getMechanicById(@PathVariable("id") Long id) {
        return mechanicService.toDto(mechanicService.getById(id));
    }

    /**
     * Удаляет механика
     *
     * @param mechanicDto
     */
    @DeleteMapping
    public void deleteMechanic(@RequestBody MechanicDto mechanicDto) {
        mechanicService.delete(mechanicService.fromDto(mechanicDto));
    }


}
