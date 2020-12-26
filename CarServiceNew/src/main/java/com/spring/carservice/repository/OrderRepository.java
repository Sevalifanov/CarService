package com.spring.carservice.repository;

import com.spring.carservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.*;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
