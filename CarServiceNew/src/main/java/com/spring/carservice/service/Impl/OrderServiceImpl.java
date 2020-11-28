package com.spring.carservice.service.Impl;

import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dao.OrderDao;
import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.model.Order;
import com.spring.carservice.service.CarService;
import com.spring.carservice.service.MechanicService;
import com.spring.carservice.service.OrderService;
import com.spring.carservice.validator.CarDtoValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LogManager.getLogger(OrderServiceImpl.class.getName());

    private CarService carService;
    private MechanicService mechanicService;
    private OrderDao orderDao;


    @Autowired
    public OrderServiceImpl(CarService carService, MechanicService mechanicService, OrderDao orderDao) {
        this.carService = carService;
        this.mechanicService = mechanicService;
        this.orderDao = orderDao;
    }


    @Value("${garage.diagnostics.price}")
    private Integer price;

    /**
     * Добавляем  машину в наш сервис на диагностику
     *
     * @param carDto
     * @return Возвращаем заказ-наряд
     */
    @Override
    public OrderDto add(CarDto carDto) {
        if(carService.getById(carDto.getId())==null){
            throw new RuntimeException("Car is not added to service. Firstly use /addCar ");
        }
        if(findOrderDtoByCarId(carDto.getId())!=null){
            throw new RuntimeException("Car is already in service, you should add another car please");
        }
        Order order = orderDao.addOrder(new Order(
                Date.valueOf(LocalDate.now()),
                carService.fromDto(carDto),
                mechanicService.fromDto(mechanicService.getFreeMechanic()),
                Long.valueOf(new Random().nextInt(price))
        ));
        return toDto(order);
    }

    /**
     * Метод ищет заказ наряды по VIN
     *
     * @param id - VIN
     * @return возвращает заказ наряд, если такой вин есть
     */
    @Override
    public OrderDto findOrderDtoByCarId(Long id) {
        for (OrderDto orderDto : getOrders()) {
            if (id.equals(orderDto.getCarDto().getId())) {
                return orderDto;
            }
        }

        return null;

    }

    /**
     * Возвращаем список заказ-нарядов
     *
     * @return
     */

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = orderDao.getOrders();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(new OrderDto(
                    order.getPublicationDate(),
                    carService.toDto(order.getCar()),
                    mechanicService.toDto(order.getMechanic()),
                    order.getPrice()
            ));

        }
        return orderDtos;
    }

    /**
     * Этот метод отдает машину владельцу, заказ закрывается
     * если такой автомобиль отсутствует сейчас в списке авто на обслуживании, то вылетит эксепшн
     * @param id- Айди автомобиля
     * @return если заказ с таким айди авто есть то вылетит true
     */
    @Override
    public boolean deleteOrderByCarId(Long id) {
        if(findOrderDtoByCarId(id)==null){
            throw new RuntimeException("Car with this id is absent, please enter another car ID please");
        }
        for (Order order : orderDao.getOrders()) {
            if (order.getCar().getId().equals(id)) {
                return orderDao.deleteOrder(order);
            }
        }
        return false;
    }
    @Override
    public OrderDto toDto(Order order) {
        return new OrderDto(
                order.getPublicationDate(),
                carService.toDto(order.getCar()),
                mechanicService.toDto(order.getMechanic()),
                order.getPrice());
    }
    @Override
    public Order fromDto(OrderDto orderDto) {
        return new Order(
                orderDto.getPublicationDate(),
                carService.fromDto(orderDto.getCarDto()),
                mechanicService.fromDto(orderDto.getMechanicDto()),
                orderDto.getPrice());
    }


}
