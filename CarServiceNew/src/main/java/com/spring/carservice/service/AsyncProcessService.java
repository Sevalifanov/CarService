package com.spring.carservice.service;

/**
 * данный сервис имеет ассихронный метод по
 * добавлению данных в БД о создании новых объектов в сервисе
 * правда пока он ничего не делает, просто показывает вид, что есть
 * операция которая проходит достаточно долго...
 */
public interface AsyncProcessService {

    void postOperation();
}
