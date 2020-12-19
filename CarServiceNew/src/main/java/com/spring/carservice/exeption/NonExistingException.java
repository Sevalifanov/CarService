package com.spring.carservice.exeption;

/**
 * Исключение выбрасывается если объект не существует
 */
public class NonExistingException extends NullPointerException {

    public NonExistingException(String message) {
        super(message);
    }
}

