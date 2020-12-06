package com.spring.carservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**

 * OrderDto -воплощение этого шаблона dto для модели Order
 */
public class OrderDto {
    /**
     * Id - айдентикационный номер заказа
     */
    private Long id;
    /**
     * publicationDate -дата создания заказа на обслуживание автомобиля.
     */
    private LocalDateTime publicationDate;
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
    private BigDecimal price;

    public OrderDto(){}

    public OrderDto(Long id, LocalDateTime publicationDate, CarDto carDto, MechanicDto mechanicDto, BigDecimal price) {
        this.id = id;
        this.publicationDate = publicationDate;
        this.carDto = carDto;
        this.mechanicDto = mechanicDto;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "id=" + id +
                ", publicationDate=" + publicationDate +
                ", carDto=" + carDto +
                ", mechanicDto=" + mechanicDto +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDto)) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(getId(), orderDto.getId()) &&
                Objects.equals(getPublicationDate(), orderDto.getPublicationDate()) &&
                Objects.equals(getCarDto(), orderDto.getCarDto()) &&
                Objects.equals(getMechanicDto(), orderDto.getMechanicDto()) &&
                Objects.equals(getPrice(), orderDto.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPublicationDate(), getCarDto(), getMechanicDto(), getPrice());
    }
}

