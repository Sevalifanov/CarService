package com.spring.carservice.exeption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.UUID;

@PropertySource("classpath:validation.properties")
@RestControllerAdvice(basePackages = "com.spring.carservice.controller")
public class GarageExceptionHandler {
    private static final Logger log = LogManager.getLogger(GarageExceptionHandler.class.getName());

    @Value("${system.name}")
    private String systemName;

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> validationException(ValidationException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                Instant.now(),
                "illegalArgumentException",
                exception.getStrErrors().toString(),
                systemName
        );
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> runtimeException(Exception exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                Instant.now(),
                "RunTimeException",
                "Something goes wrong",
                systemName
        );
        log.debug(exception.getStackTrace(), exception);
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseError> nonExistingException(NonExistingException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                Instant.now(),
                "NonExistingException",
                "object does not exist or cannot be created ",
                systemName
        );
        log.debug(exception.getStackTrace(), exception);
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


