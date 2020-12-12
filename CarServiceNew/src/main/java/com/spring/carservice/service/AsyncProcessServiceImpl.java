package com.spring.carservice.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.LockSupport;

@Service
public class AsyncProcessServiceImpl implements AsyncProcessService {

    private static final Logger log = LogManager.getLogger(AsyncProcessServiceImpl.class.getName());
    @Override
    @Async
    public void postOperation() {

        log.info("post operation begin in thread : "+Thread.currentThread().getName() );
        LockSupport.parkNanos(1_000_000_000L);
        log.info("25%"+Thread.currentThread().getName());
        LockSupport.parkNanos(1_000_000_000L);
        log.info("50%"+Thread.currentThread().getName());
        LockSupport.parkNanos(1_000_000_000L);
        log.info("75%"+Thread.currentThread().getName());
        LockSupport.parkNanos(1_000_000_000L);
        log.info("100%"+Thread.currentThread().getName());
        log.info("<---post operation complete");
    }
}
