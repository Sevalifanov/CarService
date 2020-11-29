package com.spring.carservice.exeption.dao;

import com.spring.carservice.exeption.ResponseError;

import java.util.List;

public interface ResponseErrorDao {

    void add(ResponseError responseError);

    List<ResponseError> getErrors();

}
