package com.spring.carService.dto;

import java.util.Date;

public class OrderDto {
    private Date publicationDate;
    private CarDto carDto;
    private MechanicDto mechanicDto;
    private Long price;

    public OrderDto(Date publicationDate, CarDto carDto, MechanicDto mechanicDto, Long price) {
        this.publicationDate = publicationDate;
        this.carDto = carDto;
        this.mechanicDto = mechanicDto;
        this.price = price;
    }

    public OrderDto() {
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "publicationDate=" + publicationDate +
                ", carDto=" + carDto +
                ", mechanicDto=" + mechanicDto +
                ", price=" + price +
                '}';
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public CarDto getCarDto() {
        return carDto;
    }

    public void setCarDto(CarDto carDto) {
        this.carDto = carDto;
    }

    public MechanicDto getMechanicDto() {
        return mechanicDto;
    }

    public void setMechanicDto(MechanicDto mechanicDto) {
        this.mechanicDto = mechanicDto;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }
}

