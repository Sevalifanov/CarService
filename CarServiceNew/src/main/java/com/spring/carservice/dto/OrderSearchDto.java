package com.spring.carservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * OrderSearchDto -модель для поиска заказов
 */
public class OrderSearchDto {
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
}
