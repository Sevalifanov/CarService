package com.spring.carservice.model;

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
}
