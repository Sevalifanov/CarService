package com.spring.carservice.dto;

import java.util.Date;

/**
 * Data Transfer Object (DTO) — один из шаблонов проектирования, используется для передачи данных
 * между подсистемами приложения. Data Transfer Object
 * OrderDto -воплощение этого шаблона для модели Order
 */
public class OrderDto {
    /**
     * publicationDate -дата создания заказа на обслуживание автомобиля.
     */
    private Date publicationDate;
    /**
     * carDto -автомобиль поступивший на обслуживание.
     */
    private CarDto carDto;
    /**
     * mechanicDto -механик осблуживающий Т.С.
     */
    private MechanicDto mechanicDto;
    /**
     * price -оцененный сервисом труд механика, выраженный в денежном эквиваленте.
     */
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
                "publicationDate=" + publicationDate.getTime() +
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

