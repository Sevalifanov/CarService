package com.spring.carservice.exeption;

import java.util.UUID;

public class ResponseError {

        private UUID id;
        private Long timestamp;
        private String code;
        private String message;
        private String system;



    public ResponseError(UUID id, Long timestamp, String code, String message, String system) {
        this.id = id;
        this.timestamp = timestamp;
        this.code = code;
        this.message = message;
        this.system = system;
    }

    public ResponseError() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
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

