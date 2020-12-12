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
    private Long carId;

    /**
     * mechanicDto -механик осблуживающий Т.С.
     */
    private Long mechanicId;

    /**
     * price -оцененный сервисом труд механика, выраженный в денежном эквиваленте.
     */
    private BigDecimal price;

    public OrderDto(){}

    public OrderDto(Long id, LocalDateTime publicationDate, Long carId, Long mechanicId, BigDecimal price) {
        this.id = id;
        this.publicationDate = publicationDate;
        this.carId = carId;
        this.mechanicId = mechanicId;
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

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(Long mechanicId) {
        this.mechanicId = mechanicId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDto)) return false;
        OrderDto orderDto = (OrderDto) o;
        return Objects.equals(getId(), orderDto.getId()) &&
                Objects.equals(getPublicationDate(), orderDto.getPublicationDate()) &&
                Objects.equals(getCarId(), orderDto.getCarId()) &&
                Objects.equals(getMechanicId(), orderDto.getMechanicId()) &&
                Objects.equals(getPrice(), orderDto.getPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPublicationDate(), getCarId(), getMechanicId(), getPrice());
    }
}

