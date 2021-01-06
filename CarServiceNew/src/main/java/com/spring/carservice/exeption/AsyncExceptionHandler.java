package com.spring.carservice.exeption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

import java.lang.reflect.Method;

/**
 * Обработчик ошибок для ассинхронных вызовов
 */
public class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(AsyncExceptionHandler.class.getName());

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {
        log.error("Exception message - " + throwable.getMessage() + "Method name - " + method.getName());
    }

}
