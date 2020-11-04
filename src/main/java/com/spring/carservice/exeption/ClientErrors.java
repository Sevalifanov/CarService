package com.spring.carservice.exeption;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClientErrors {
    List<ResponseError> errors = new ArrayList<>();
    public void add(ResponseError responseError){errors.add(responseError);}

    public List<ResponseError> getErrors() {
        return errors;
    }
}
