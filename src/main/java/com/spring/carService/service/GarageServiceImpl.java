package com.spring.carService.service;

import com.spring.carService.DAO.CarDao;
import com.spring.carService.DAO.MechanicDao;
import com.spring.carService.DAO.OrderDao;
import com.spring.carService.model.Car;
import com.spring.carService.model.Mechanic;
import com.spring.carService.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

@Service
public class GarageServiceImpl implements GarageService {
    @Autowired
    private CarDao carDao;
    @Autowired
    private MechanicDao mechanicDao;
    @Autowired
    private OrderDao orderDao;

    public GarageServiceImpl(CarDao carDao, MechanicDao mechanicDao, OrderDao orderDao) {
        this.carDao = carDao;
        this.mechanicDao = mechanicDao;
        this.orderDao = orderDao;
    }
    public GarageServiceImpl(){};

    public boolean addNewCar(Car car, Mechanic mechanic, Long price) {
        carDao.addCar(car);
        mechanicDao.saveMechanic(mechanic);
        orderDao.saveOrder(new Order(
                Date.from(Instant.now()),
                car,
                mechanic,
                price
        ));
        System.out.println("New Order added");

        return true;
    }

}
