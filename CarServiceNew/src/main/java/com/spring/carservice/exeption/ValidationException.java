package com.spring.carservice.exeption;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ValidationException исключене которое срабатывает при ошибках в валидации.
 */
public class ValidationException extends IllegalArgumentException {

    /**
     * errors- список ошибок , собираемых при срабатывании исключения
     */
    private List<Error> errors;

    public ValidationException() {
        super();
    }

    public ValidationException(String s) {
        super(s);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValidationException(Throwable cause) {
        super(cause);
    }
    // ошибки валидации

    public ValidationException(String message, List<Error> errors) {
        super(message);
        this.errors = errors;
    }

    /**
     * Возвращает ошибки при валидации
     *
     * @return errors
     */
    public List<Error> getErrors() {
        return errors;
    }

    /**
     * возвращаеn errors List<String> ошибок
     *
     * @return List<String>
     */
    public List<String> getStrErrors() {
        List<String> strErrors = errors.stream()
                .map((error) -> error.getMessage())
                .collect(Collectors.toList());
        return strErrors;
    }


}
