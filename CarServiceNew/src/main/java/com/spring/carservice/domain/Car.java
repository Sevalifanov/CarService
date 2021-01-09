package com.spring.carservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * Автомобиль- транспортное средство, используемое для перевозки людей или грузов.
 * Каждый автомобиль порой нуждается в диагностике, зачем и приезжает в наш сервис.
 */

@Entity
@Table(name = "car")
public class Car {

    /**
     * id  -автомобиля - уникальный номер для любого т.с. на планете
     */
    @Id
    @Column
    private Long id;

    /**
     * brand -марка автомобля например: Ford, Toyota, etc..
     */
    private String brand;

    /**
     * domain -модель автомобиля. Каждая марка автомобилей имеет несколько моделей предствленных на рынке.
     * например : Ford F-150, Ford Focus, Ford Explorer, etc.
     */
    private String modelName;

    public Car() {
    }

    public Car(Long id) {
        this.id = id;
    }

    public Car(Long id, String brand, String modelName) {
        this.id = id;
        this.brand = brand;
        this.modelName = modelName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(getId(), car.getId()) &&
                Objects.equals(getBrand(), car.getBrand()) &&
                Objects.equals(getModelName(), car.getModelName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getBrand(), getModelName());
    }

}
