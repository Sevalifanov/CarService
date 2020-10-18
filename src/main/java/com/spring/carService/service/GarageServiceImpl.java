package com.spring.carService.service;

import com.spring.carService.DAO.CarDao;
import com.spring.carService.DAO.MechanicDao;
import com.spring.carService.DAO.OrderDao;
import com.spring.carService.model.Car;
import com.spring.carService.model.Mechanic;
import com.spring.carService.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
@Configuration
@PropertySource("classpath:application.properties")
@Service
public class GarageServiceImpl implements GarageService {
    @Autowired
    private CarDao carDao;
    @Autowired
    private MechanicDao mechanicDao;
    @Autowired
    private OrderDao orderDao;
    @Value("${spring.appconf.price}")
    private String price;

    public GarageServiceImpl(CarDao carDao, MechanicDao mechanicDao, OrderDao orderDao) {
        this.carDao = carDao;
        this.mechanicDao = mechanicDao;
        this.orderDao = orderDao;
    }
    public GarageServiceImpl(){};

    public boolean addNewCar(Car car, Mechanic mechanic) {
        carDao.addCar(car);
        mechanicDao.saveMechanic(mechanic);
        orderDao.saveOrder(new Order(
                Date.from(Instant.now()),
                car,
                mechanic,
                Long.valueOf(price)
        ));
        System.out.println("New Order added");

        return true;
    }

}
