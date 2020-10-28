package com.spring.carService.service;

import com.spring.carService.dao.CarDao;
import com.spring.carService.dao.MechanicDao;
import com.spring.carService.dao.OrderDao;
import com.spring.carService.dto.CarDto;
import com.spring.carService.dto.OrderDto;
import com.spring.carService.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private CarService carService;
    private MechanicService mechanicService;
    private OrderDao orderDao;
    private CarDao carDao;
    private MechanicDao mechanicDao;

    @Autowired
    public OrderService(CarService carService, MechanicService mechanicService, OrderDao orderDao, CarDao carDao, MechanicDao mechanicDao) {
        this.carService = carService;
        this.mechanicService = mechanicService;
        this.orderDao = orderDao;
        this.carDao = carDao;
        this.mechanicDao = mechanicDao;
    }

    @Value("${garage.diagnostics.price}")
    private Long price;

    /**
     * Получаем новую машину в наш сервис на диагностику
     *
     * @param carDto
     * @return Возвращаем заказ-наряд
     */
    public OrderDto add(CarDto carDto) {
        carService.add(carService.fromDto(carDto));
        Order order = orderDao.saveOrder(new Order(
                Date.valueOf(LocalDate.now()),
                carService.fromDto(carDto),
                mechanicDao.getMechanicById(1L),
                price
        ));
        return toDto(order);
    }

    /**
     * Метод ищет заказ наряды по VIN
     *
     * @param id - VIN
     * @return возвращает заказ наряд, если такой вин есть
     */

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

    public boolean deleteOrderByCarId(Long id) {
        for (Order order : orderDao.getOrders()) {
            if (order.getCar().getId().equals(id)) {
                return orderDao.deleteOrder(order);
            }
        }
        return false;
    }

    public OrderDto toDto(Order order) {
        return new OrderDto(
                order.getPublicationDate(),
                carService.toDto(order.getCar()),
                mechanicService.toDto(order.getMechanic()),
                order.getPrice());
    }

    public Order fromDto(OrderDto orderDto) {
        return new Order(
                orderDto.getPublicationDate(),
                carService.fromDto(orderDto.getCarDto()),
                mechanicService.fromDto(orderDto.getMechanicDto()),
                orderDto.getPrice());
    }


}
