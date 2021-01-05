package com.spring.carservice.service;

import com.spring.carservice.dto.CarDto;
import com.spring.carservice.domain.Car;
import com.spring.carservice.dto.CarSearchDto;
import com.spring.carservice.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Transactional
    @Override
    public CarDto add(CarDto car) {
        return toDto(carRepository.save(fromDto(car)));
    }

    @Transactional
    @Override
    public CarDto getById(Long Id) {
        return toDto(carRepository.getOne(Id));
    }

    @Transactional
    @Override
    public void delete(Long id) {
        Car car = carRepository.getOne(id);
        carRepository.delete(car);
    }

    @Transactional
    @Override
    public CarDto update(CarDto carDto) {
        return toDto(carRepository.save(fromDto(carDto)));
    }

    /**
     * @param carSearchDto принимаем модель для поиска
     * @param pageable     параметры для страницы
     * @return список автомобилей в формате страницы
     */
    @Override
    public Page<CarDto> getCars(CarSearchDto carSearchDto, Pageable pageable) {
        return carRepository.findAll(getSpecification(carSearchDto), pageable).map(car -> toDto(car));
    }

    private Specification<Car> getSpecification(CarSearchDto carSearchDto) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (carSearchDto.getBrand() != null) {
                predicates.add(root.get("brand").in(carSearchDto.getBrand()));
            }

            if (carSearchDto.getModelName() != null) {
                predicates.add(builder.lower(root.get("modelName")).in(carSearchDto.getModelName()));
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    private Car fromDto(CarDto carDto) {
        return new Car(
                carDto.getId(),
                carDto.getBrand(),
                carDto.getModelName()
        );
    }

    private CarDto toDto(Car car) {
        return new CarDto(
                car.getId(),
                car.getBrand(),
                car.getModelName()
        );
    }

}
