package com.spring.carservice.service.Impl;

import com.spring.carservice.dao.OrderDao;
import com.spring.carservice.dto.CarDto;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.model.Order;
import com.spring.carservice.service.AsyncProcessService;
import com.spring.carservice.service.CarService;
import com.spring.carservice.service.MechanicService;
import com.spring.carservice.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
        if (getOrderDtoByCarId(carDto.getId()) != null) {
            throw new RuntimeException("Car is already in service, you should add another car please");
        }
        Order order = orderDao.addOrder(new Order(
                System.currentTimeMillis(),
                LocalDateTime.now(),
                carService.fromDto(carDto),
                mechanicService.fromDto(mechanicService.getFreeMechanic()),
                BigDecimal.valueOf(new Random().nextInt(price))
        ));
        return toDto(order);
    }

    @Override
    public OrderDto getOrderDtoByCarId(Long id) {
        for (OrderDto orderDto : getOrders()) {
            if (id.equals(orderDto.getCarDto().getId())) {
                return orderDto;
            }
        }
        return null;
    }

    @Override
    public OrderDto getById(Long id) {
        return toDto(orderDao.getById(id));
    }

    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = orderDao.getOrders();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(toDto(order));
        }
        return orderDtos;
    }

    @Override
    public boolean delete(Long id) {
        return orderDao.remove(orderDao.getById(id));
    }

    @Override
    public OrderDto update(OrderDto orderDto) {
        delete(orderDto.getId());
        orderDao.addOrder(fromDto(orderDto));
        return orderDto;
    }

    /**
     * Данный метод преобразовывает объект типа Order в объект типа OrderDto
     *
     * @param order - Объект типа Order
     * @return OrderDto - Объект типа OrderDto
     */
    private OrderDto toDto(Order order) {
        return new OrderDto(
                order.getId(),
                order.getPublicationDate(),
                carService.toDto(order.getCar()),
                mechanicService.toDto(order.getMechanic()),
                order.getPrice());
    }

    /**
     * Метод преобразовывает объект  из OrderDto в стандартный вид Order
     *
     * @param orderDto - Объект типа OrderDto
     * @return Order -Объект типа Order
     */
    private Order fromDto(OrderDto orderDto) {
        return new Order(
                orderDto.getId(),
                orderDto.getPublicationDate(),
                carService.fromDto(orderDto.getCarDto()),
                mechanicService.fromDto(orderDto.getMechanicDto()),
                orderDto.getPrice());
    }
}
