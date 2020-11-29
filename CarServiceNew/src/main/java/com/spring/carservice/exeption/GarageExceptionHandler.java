package com.spring.carservice.exeption;

import com.spring.carservice.exeption.dao.ResponseErrorDao;
import com.spring.carservice.exeption.dao.impl.ResponseErrorDaoImpl;
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
public class GarageExceptionHandler {
    private static final Logger log = LogManager.getLogger(GarageExceptionHandler.class.getName());

    private ResponseErrorDao responseErrorDao;

    public GarageExceptionHandler(ResponseErrorDao responseErrorDao) {
        this.responseErrorDao = responseErrorDao;
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ResponseError> illegalArgumentException(IllegalArgumentException exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                System.currentTimeMillis(),
                "illegalArgumentException",
                exception.getMessage(),
                "validation"
        );
        responseErrorDao.add(error);
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> runtimeException(Exception exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                System.currentTimeMillis(),
                "RunTimeException",
                "Something goes wrong",
                "mySystem"
        );
        log.debug(exception.getStackTrace(), exception);
        responseErrorDao.add(error);
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ResponseError> nullPointerException(Exception exception) {
        log.debug(exception.getLocalizedMessage(), exception);
        ResponseError error = new ResponseError(
                UUID.randomUUID(),
                System.currentTimeMillis(),
                "NullPointerException",
                "object does not exist or cannot be created ",
                "mySystem"
        );
        log.debug(exception.getStackTrace(), exception);
        responseErrorDao.add(error);
        return new ResponseEntity<>(error, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


