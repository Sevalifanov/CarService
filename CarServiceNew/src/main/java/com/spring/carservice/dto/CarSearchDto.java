package com.spring.carservice.dto;

/**
 * CarSearchDto -модель для поиска автомобилей
 */
public class CarSearchDto {

    /**
     * brand -марка автомобля например: Ford, Toyota, etc..
     */
    private String brand;

    /**
     * domain -модель автомобиля. Каждая марка автомобилей имеет несколько моделей предствленных на рынке.
     * например : Ford F-150, Ford Focus, Ford Explorer, etc.
     */
    private String modelName;

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
