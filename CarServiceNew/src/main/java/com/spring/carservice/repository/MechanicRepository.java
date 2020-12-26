package com.spring.carservice.repository;

import com.spring.carservice.domain.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

}
