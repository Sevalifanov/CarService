package com.spring.carservice.controller;

import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.exeption.NonExistingException;
import com.spring.carservice.service.MechanicService;
import com.spring.carservice.validator.MechanicDtoValidator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/v1/mechanic")
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
    public ResponseEntity<MechanicDto> addMechanic(@RequestBody MechanicDto mechanicDto, UriComponentsBuilder uriBuilder) {
        mechanicDtoValidator.validate(mechanicDto);
        mechanicService.add(mechanicDto);
        return ResponseEntity.created(uriBuilder.path("/api/v1/mechanic/" + mechanicDto.getId()).buildAndExpand(mechanicDto).toUri()).body(mechanicDto);
    }

    /**
     * Возвращает механика по айди
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    public MechanicDto getMechanicById(@PathVariable("id") Long id) {
        return mechanicService.getById(id);
    }

    /**
     * Удаляет механика
     *
     * @param id
     */
    @DeleteMapping(value = "/{id}")
    public void deleteMechanic(@PathVariable("id") Long id) {
        mechanicService.delete(id);
    }

    /**
     * update mechanics domain information
     *
     * @param mechanicDto
     * @param id
     * @return
     */
    @PutMapping(value = "/{id}")
    public MechanicDto updateMechanic(@RequestBody MechanicDto mechanicDto, @PathVariable("id") Long id) {
        if (!mechanicDto.getId().equals(id)) {
            throw new NonExistingException("You tried to update a mechanic did not exist");
        }
        mechanicDtoValidator.validate(mechanicDto);
        return mechanicService.update(mechanicDto);
    }


}
