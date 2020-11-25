package com.spring.carservice.service.Impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.LockSupport;
@Service
public class AsyncProcessService {

    private static final Logger log = LogManager.getLogger(AsyncProcessService.class.getName());
    @Async
    public void postOperation() {
        log.info("post operation begin");
        System.out.print(Thread.currentThread().getName());
        LockSupport.parkNanos(1_000_000_000L);
        System.out.print("{<-><-><-><->");
        LockSupport.parkNanos(1_000_000_000L);
        System.out.print("<-><-><-><->");
        LockSupport.parkNanos(1_000_000_000L);
        System.out.print("<-><-><-><->");
        LockSupport.parkNanos(1_000_000_000L);
        System.out.print("<-><-><-><->}");
        log.info("post operation complete");
    }
}
