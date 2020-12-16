package com.spring.carservice.validator;

import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.exeption.ValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * MechanicDtoValidator - класс валидирующий входные значения для модели mechanic
 */
@Component
@PropertySource("classpath:validation.properties")
public class MechanicDtoValidator {
    private static final Logger logger = LogManager.getLogger(MechanicDtoValidator.class.getName());

    @Value("${exception.mechanic.validate}")
    private String exceptionMechanicValidateMessage;

    /**
     * Проверяем на валидность  mechanicDto который прилетает нам от внешней системы
     * Метод выбросит экспешн, если у carDto будут некорректные поля.
     *
     * @param mechanicDto - механик
     */
    public void validate(MechanicDto mechanicDto) {
        List<Error> errors = new ArrayList<>();
        if (mechanicDto.getId() == null) {
            logger.error("try to enter incorrect mechanicId ");
            errors.add(new Error(exceptionMechanicValidateMessage + "incorrect mechanicId"));
        }
        if (mechanicDto.getLastName().equals("")) {
            logger.error("try to enter incorrect LastName");
            errors.add(new Error(exceptionMechanicValidateMessage + " incorrect LastName"));
        }
        if (mechanicDto.getFirstName().equals("")) {
            logger.error("try to enter incorrect FirstName");
            errors.add(new Error(exceptionMechanicValidateMessage + "incorrect FirstName"));
        }
        if (!errors.isEmpty()) {
            throw new ValidationException(exceptionMechanicValidateMessage, errors);
        }
    }
}