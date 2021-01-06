package com.spring.carservice.exeption;

import java.time.Instant;
import java.util.UUID;

/**
 * ResponseError - модель для отображения ошибки
 */
public class ResponseError {
    /**
     * id - уникальный номер события
     */
    private UUID id;

    /**
     * timestamp- время события
     */
    private Instant timestamp;

    /**
     * code - код ошибки
     */
    private String code;

    /**
     * message -сообщение о ошибке
     */
    private String message;

    /**
     * system -место ошибки
     */
    private String system;

    public ResponseError() {
    }

    public ResponseError(UUID id, Instant timestamp, String code, String message, String system) {
        this.id = id;
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;
        this.system = system;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }
}

