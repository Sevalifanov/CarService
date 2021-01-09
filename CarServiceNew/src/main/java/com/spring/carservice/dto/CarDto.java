package com.spring.carservice.dto;

/**
 * CarDto -модель для создания автомобиля
 */
public class CarDto {
    /**
     * id  -автомобиля - уникальный номер для любого т.с. на планете
     */
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

    public CarDto() {
    }

    public CarDto(Long id, String brand, String modelName) {
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
        return "CarDto{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", modelName='" + modelName + '\'' +
                '}';
    }
}
