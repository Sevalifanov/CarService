package com.spring.carService.Service;

import com.spring.carService.DAO.CarDao;
import com.spring.carService.DAO.MechanicDao;
import com.spring.carService.model.Car;
import com.spring.carService.model.Mechanic;

public class GarageServiceImpl implements GarageService {

    private CarDao carDao;
    private MechanicDao mechanicDao;

    public GarageServiceImpl(CarDao carDao, MechanicDao mechanicDao) {
        this.carDao = carDao;
        this.mechanicDao = mechanicDao;
    }

    public boolean addNewCar(Car car, Mechanic mechanic){
        carDao.addCar(car);
        mechanicDao.addCarToMechanic(mechanic,car);
        System.out.println("car added");
        return true;
    }
}
