package com.spring.carservice.service;

import com.spring.carservice.dto.OrderDto;
import com.spring.carservice.dto.OrderSearchDto;
import com.spring.carservice.exeption.NonExistingException;
import com.spring.carservice.domain.Order;

import com.spring.carservice.repository.CarRepository;
import com.spring.carservice.repository.MechanicRepository;
import com.spring.carservice.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class.getName());

    private CarRepository carRepository;
    private MechanicRepository mechanicRepository;
    private OrderRepository orderRepository;

    public OrderServiceImpl(CarRepository carRepository, MechanicRepository mechanicRepository, OrderRepository orderRepository) {
        this.carRepository = carRepository;
        this.mechanicRepository = mechanicRepository;
        this.orderRepository = orderRepository;
    }

    @Value("${garage.diagnostics.price}")
    private Integer price;

    @Transactional
    @Override
    public OrderDto add(OrderDto orderDto) {
        if (carRepository.findById(orderDto.getCarId()) == null) {
            throw new NonExistingException("Car is not added to service. Firstly save car ");
        }
        if (mechanicRepository.findById(orderDto.getMechanicId()) == null) {
            throw new NonExistingException("Mechanic is not added to service. Firstly save Mechanic ");
        }
        if (getOrderDtoByCarId(orderDto.getCarId()) != null) {
            throw new NonExistingException("Car is already in service, you should add another car please, or use update");
        }
        return toDto(orderRepository.save(fromDto(orderDto)));
    }


    private OrderDto getOrderDtoByCarId(Long id) {
        for (OrderDto orderDto : getOrders()) {
            if (id.equals(orderDto.getCarId())) {
                return orderDto;
            }
        }
        return null;
    }

    @Transactional
    @Override
    public OrderDto getById(Long id) {
        return toDto(orderRepository.getOne(id));
    }

    @Transactional
    @Override
    public List<OrderDto> getOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            orderDtos.add(toDto(order));
        }
        return orderDtos;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    /**
     * @param orderSearchDto принимаем модель для поиска
     * @param pageable       параметры для страницы
     * @return список заказов в формате страницы
     */
    @Override
    public Page<OrderDto> getOrders(OrderSearchDto orderSearchDto, Pageable pageable) {
        return orderRepository.findAll(getSpecification(orderSearchDto), pageable).map(order -> toDto(order));
    }

    private Specification<Order> getSpecification(OrderSearchDto orderSearchDto) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (orderSearchDto.getPublicationDate() != null) {
                predicates.add(root.get("publicationDate").in(orderSearchDto.getPublicationDate()));
            }
            if (orderSearchDto.getCarId() != null) {
                predicates.add(root.get("car").in(orderSearchDto.getCarId()));
            }
            if (orderSearchDto.getMechanicId() != null) {
                predicates.add(root.get("mechanic").in(orderSearchDto.getMechanicId()));
            }
            if (orderSearchDto.getPrice() != null) {
                predicates.add(root.get("price").in(orderSearchDto.getPrice()));
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };

    }

    @Transactional
    @Override
    public OrderDto update(OrderDto orderDto) {
        return toDto(orderRepository.save(fromDto(orderDto)));
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
                carRepository.getOne(orderDto.getCarId()),
                mechanicRepository.getOne(orderDto.getMechanicId()),
                orderDto.getPrice());
    }
}