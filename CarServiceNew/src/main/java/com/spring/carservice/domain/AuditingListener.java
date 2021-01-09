package com.spring.carservice.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

public class AuditingListener {

    private static final Logger log = LoggerFactory.getLogger(AuditingListener.class.getName());

    @PrePersist
    public void prePersist(CreateAtIdentified createAtIdentified) {
        LocalDateTime localDateTime = LocalDateTime.now();
        createAtIdentified.setCreatedAt(localDateTime);
        log.info("row created at " + localDateTime);
    }

    @PreUpdate
    public void preUpdate(CreateAtIdentified createAtIdentified) {
        LocalDateTime localDateTime = LocalDateTime.now();
        createAtIdentified.setUpdatedAt(localDateTime);
        log.info("row updated at " + localDateTime);
    }

}
