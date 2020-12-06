package com.spring.carservice.validator;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.MechanicDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:validation.properties")
public class MechanicDtoValidator {
    private static final Logger logger = LogManager.getLogger(MechanicDtoValidator.class.getName());

    @Value("${exception.mechanic.validate}")
    private String exceptionMechanicValidateMessage;

    /**
     * Проверяем на валидность  mechanicDto который прилетает нам от внешней системы
     * Метод выбросит экспешн, если у carDto будут некорректные поля.
     * @param mechanicDto - механик
     */
    public void validate(MechanicDto mechanicDto) {
        if (mechanicDto.getId() == null || mechanicDto.getFirstName() == null || mechanicDto.getLastName() == null || mechanicDto.getLastName().equals("") || mechanicDto.getFirstName().equals("")) {
            logger.error("try to enter incorrect info");
            throw new IllegalArgumentException(exceptionMechanicValidateMessage);
        }
    }

}