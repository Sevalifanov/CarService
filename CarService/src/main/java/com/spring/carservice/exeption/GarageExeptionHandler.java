package com.spring.carservice.exeption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.UUID;


@RestControllerAdvice(basePackages = "com.spring.carservice.controller")
public class GarageExeptionHandler {
    private ClientErrors clientErrors;
    @Autowired
    public GarageExeptionHandler(ClientErrors clientErrors) {
        this.clientErrors = clientErrors;
    }

    private static final Logger log = LogManager.getLogger(GarageExeptionHandler.class.getName());

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> illegalArgumentException(IllegalArgumentException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                System.currentTimeMillis(),
                "illegalArgumentException",
                exception.getLocalizedMessage(),
                "validation"
        );
        clientErrors.add(error);
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ResponseError> runtimeException(RuntimeException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                System.currentTimeMillis(),
                "BadRequest",
                exception.getLocalizedMessage(),
                "mySystem"
        );
        clientErrors.add(error);
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> runtimeException(Exception exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                System.currentTimeMillis(),
                "unknown",
                "Что-то пошло не так",
                "mySystem"
        );
        log.debug(exception.getStackTrace(), exception);
        clientErrors.add(error);
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


