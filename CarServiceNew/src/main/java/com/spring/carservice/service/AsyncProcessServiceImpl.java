package com.spring.carservice.service;

import com.spring.carservice.service.AsyncProcessService;
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
        System.out.println("post operation begin in thread : "+Thread.currentThread().getName() );
        LockSupport.parkNanos(1_000_000_000L);
        System.out.print("25%");
        LockSupport.parkNanos(1_000_000_000L);
        System.out.print("50%");
        LockSupport.parkNanos(1_000_000_000L);
        System.out.print("75%");
        LockSupport.parkNanos(1_000_000_000L);
        System.out.print("100%");
        System.out.println("<---post operation complete");
    }
}
