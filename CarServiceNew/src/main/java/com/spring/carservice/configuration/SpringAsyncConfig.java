package com.spring.carservice.configuration;

import com.spring.carservice.exeption.AsyncExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@PropertySource("classpath:application.properties")
@Configuration
public class SpringAsyncConfig implements AsyncConfigurer {

    @Value("${thread.corePoolSize}")
    private String corePoolSize;
    @Value("${thread.maxPoolSize}")
    private String maxPoolSize;

    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(Integer.valueOf(corePoolSize));
        threadPoolTaskExecutor.setMaxPoolSize(Integer.valueOf(maxPoolSize));
        threadPoolTaskExecutor.initialize();
        return threadPoolTaskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncExceptionHandler();
    }


}
