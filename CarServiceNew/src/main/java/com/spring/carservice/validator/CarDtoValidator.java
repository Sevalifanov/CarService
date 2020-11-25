package com.spring.carservice.validator;

import com.spring.carservice.dto.CarDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CarDtoValidator {

    private static final Logger logger = LogManager.getLogger(CarDtoValidator.class.getName());

    @Value("${exception.car.validate}")
    private String exceptionCarValidateMessage;


    public void validate(CarDto carDto) {
        if (carDto.getId()==null||carDto.getModelName()==null||carDto.getBrand()==null||carDto.getModelName().equals("")||carDto.getBrand().equals("")) {
            logger.error("some field(s) is(are) incorrect");
            throw new IllegalArgumentException(exceptionCarValidateMessage);
        }



    }

}
