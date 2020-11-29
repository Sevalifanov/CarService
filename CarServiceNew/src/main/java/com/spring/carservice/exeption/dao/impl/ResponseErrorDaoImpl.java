package com.spring.carservice.exeption.dao.impl;

import com.spring.carservice.exeption.ResponseError;
import com.spring.carservice.exeption.dao.ResponseErrorDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ResponseErrorDaoImpl implements ResponseErrorDao {
    List<ResponseError> errors = new ArrayList<>();
    public void add(ResponseError responseError){errors.add(responseError);}

    public List<ResponseError> getErrors() {
        return errors;
    }
}
