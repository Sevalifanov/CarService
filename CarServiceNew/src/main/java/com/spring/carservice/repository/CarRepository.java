package com.spring.carservice.repository;

import com.spring.carservice.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

}
