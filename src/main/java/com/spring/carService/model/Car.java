package com.spring.carService.model;

public class Car {
    private Long id;
    private String brand;
    private String modelName;
    private Mechanic mechanic;

    public Car(Long id, String brand, String modelName, Mechanic mechanic) {
        this.id = id;
        this.brand = brand;
        this.modelName = modelName;
        this.mechanic = mechanic;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                ", mechanic=" + mechanic +
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

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }
}
