package com.spring.carservice.service.Impl;

import com.spring.carservice.dao.OrderDao;
import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.model.Order;
import com.spring.carservice.service.CarService;
import com.spring.carservice.service.MechanicService;
import com.spring.carservice.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LogManager.getLogger(OrderServiceImpl.class.getName());

    private AsyncProcessService asyncProcessService;
    private CarService carService;
    private MechanicService mechanicService;
    private OrderDao orderDao;

    public OrderServiceImpl(AsyncProcessService asyncProcessService, CarService carService, MechanicService mechanicService, OrderDao orderDao) {
        this.asyncProcessService = asyncProcessService;
        this.carService = carService;
        this.mechanicService = mechanicService;
        this.orderDao = orderDao;
    }

    @Value("${garage.diagnostics.price}")
    private Integer price;

    @Override
    public OrderDto add(CarDto carDto) {
        asyncProcessService.postOperation();
        if (carService.getById(carDto.getId()) == null) {
            throw new RuntimeException("Car is not added to service. Firstly use /save ");
        }
        if (findOrderDtoByCarId(carDto.getId()) != null) {
            throw new RuntimeException("Car is already in service, you should add another car please");
        }
        Order order = orderDao.addOrder(new Order(
                Date.valueOf(LocalDate.now()),
                carService.fromDto(carDto),
                mechanicService.fromDto(mechanicService.getFreeMechanic()),
                BigDecimal.valueOf(new Random().nextInt(price))
        ));
        return toDto(order);
    }

    @Override
    public OrderDto findOrderDtoByCarId(Long id) {
        for (OrderDto orderDto : getOrders()) {
            if (id.equals(orderDto.getCarDto().getId())) {
                return orderDto;
            }
        }

        return null;

    }

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

    @Override
    public boolean deleteOrderByCarId(Long id) {
        if (findOrderDtoByCarId(id) == null) {
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
