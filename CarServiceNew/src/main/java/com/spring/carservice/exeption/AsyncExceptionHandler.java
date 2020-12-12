package com.spring.carservice.exeption;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * Обработчик ошибок для ассинхронных вызовов
 */
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger log = LogManager.getLogger(AsyncExceptionHandler.class.getName());

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        log.error("Exception message - " + throwable.getMessage());
        log.error("Method name - " + method.getName());
    }

}