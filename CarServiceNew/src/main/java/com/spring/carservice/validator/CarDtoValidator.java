package com.spring.carservice.validator;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.exeption.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * CarDtoValidator - класс валидирующий входные значения для модели car
 */
@Component
@PropertySource("classpath:validation.properties")
public class CarDtoValidator {
    private static final Logger logger = LogManager.getLogger(CarDtoValidator.class.getName());

    @Value("${exception.car.validate}")
    private String exceptionCarValidateMessage;

    /**
     * Проверяем на валидность carDto который прилетает нам от внешней системы
     * Метод выбросит экспешн, если у carDto будут некорректные поля.
     *
     * @param carDto
     */
    public void validate(CarDto carDto) {
        List<Error> errors = new ArrayList<>();
        if (carDto.getId() == null) {
            logger.error("try to enter incorrect carId ");
            errors.add(new Error(exceptionCarValidateMessage + "incorrect carId"));
        }
        if (carDto.getBrand().equals("")) {
            logger.error("try to enter incorrect Brand");
            errors.add(new Error(exceptionCarValidateMessage + " incorrect Brand"));
        }
        if (carDto.getModelName().equals("")) {
            logger.error("try to enter incorrect ModelName");
            errors.add(new Error(exceptionCarValidateMessage + "incorrect ModelName"));
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(exceptionCarValidateMessage, errors);
        }
    }
}
