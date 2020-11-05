package com.spring.carservice.model;

import java.util.Objects;

/**
 * машина - имеет вин(по другому- айди), бренд , имя модели
 */
public class Car {
    private Long id;
    private String brand;
    private String modelName;


    public Car(Long id, String brand, String modelName) {
        this.id = id;
        this.brand = brand;
        this.modelName = modelName;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
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
