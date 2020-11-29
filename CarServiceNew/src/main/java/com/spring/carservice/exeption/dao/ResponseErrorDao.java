package com.spring.carservice.exeption.dao;

import com.spring.carservice.exeption.ResponseError;

import java.util.List;

public interface ResponseErrorDao {

    public void add(ResponseError responseError);

    public List<ResponseError> getErrors();

}
