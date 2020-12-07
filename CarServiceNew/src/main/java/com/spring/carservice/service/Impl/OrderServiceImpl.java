package com.spring.carservice.service.Impl;

import com.spring.carservice.dao.CarDao;
import com.spring.carservice.dao.MechanicDao;
import com.spring.carservice.dao.OrderDao;
import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.model.Order;
import com.spring.carservice.service.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LogManager.getLogger(OrderServiceImpl.class.getName());

    private CarDao carDao;
    private MechanicDao mechanicDao;
    private OrderDao orderDao;

    public OrderServiceImpl(CarDao carDao, MechanicDao mechanicDao, OrderDao orderDao) {
        this.carDao = carDao;
        this.mechanicDao = mechanicDao;
        this.orderDao = orderDao;
    }

    @Value("${garage.diagnostics.price}")
    private Integer price;

    @Override
    public OrderDto add(OrderDto orderDto) {
        if (carDao.getById(orderDto.getCarId()) == null) {
            throw new RuntimeException("Car is not added to service. Firstly save car ");
        }
        if (mechanicDao.getById(orderDto.getMechanicId()) == null) {
            throw new RuntimeException("Mechanic is not added to service. Firstly save Mechanic ");
        }
        if (getOrderDtoByCarId(orderDto.getCarId()) != null) {
            throw new RuntimeException("Car is already in service, you should add another car please, or use update");
        }
        return toDto(orderDao.save(fromDto(orderDto)));
    }

    private OrderDto getOrderDtoByCarId(Long id) {
        for (OrderDto orderDto : getOrders()) {
            if (id.equals(orderDto.getCarId())) {
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
        return toDto(orderDao.save(fromDto(orderDto)));
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
                order.getCar().getId(),
                order.getMechanic().getId(),
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
                carDao.getById(orderDto.getCarId()),
                mechanicDao.getById(orderDto.getMechanicId()),
                orderDto.getPrice());
    }
}
